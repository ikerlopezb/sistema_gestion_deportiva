package upm.utils;

import upm.utils.models.Player;
import upm.utils.models.Admin;
import upm.utils.models.User;
import upm.utils.models.Team;
import upm.utils.models.Participant;
import upm.views.ErrorView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {

    private PlayerList playerList;
    private MatchList matchList;
    private AdminList adminList;
    private TeamList teamList;
    private TournamentList tournamentlist;
    private ErrorView error;

    public Controller(PlayerList playerList, MatchList matchList, TeamList teamList, AdminList adminList, TournamentList tournamentList) {
        this.playerList = playerList;
        this.matchList = matchList;
        this.teamList = teamList;
        this.adminList = adminList;
        this.tournamentlist = tournamentList;
    }

    public void createPlayer(String forename, String surname, String key, String email, String password) {
        if (this.playerList.isPlayer(key) == null) {
            Player player = new Player(forename, surname, key, email, password);
            playerList.addPlayer(player);
        } else {
            error.writeln(Error.PLAYER_ALREADY_EXISTS);
        }
    }

    public void clearMatchmake() {
        this.matchList.clearmatchList();
    }

    public void deletePlayer(String DNI) {
        Player player = this.playerList.isPlayer(DNI);
        Tournament tournamentPlayer = this.tournamentlist.getTournamentParticipant(player);
        Team team = this.teamList.whichTeam(player);
        Tournament tournamentTeam = this.tournamentlist.getTournamentParticipant(team);

        if (player != null && !tournamentPlayer.currentlyCompeting(player) && !tournamentTeam.currentlyCompeting(team)) {
            this.playerList.removePlayer(player);
        } else {
            error.writeln(Error.PLAYER_NOT_FOUND);
        }
    }

    public void teamCreate(String teamName) {
        assert !this.teamList.existTeam(teamName);
        Team team = new Team(teamName);
        this.teamList.add(team);
    }

    public void teamAdd(String teamName, String DNI) {
        Player player = this.playerList.isPlayer(DNI);
        if (this.teamList.existTeam(teamName) && player != null) {
            Team team = this.teamList.isTeam(teamName);
            player.setInTeam(true);
            team.add(player);
        }
    }

    public void teamDelete(String teamName) {
        assert this.teamList.existTeam(teamName);
        Team team = this.teamList.isTeam(teamName);
        if (!this.tournamentlist.isCompeting(team)) {
            Tournament tournament = this.tournamentlist.getTournamentParticipant(team);
            tournament.remove(team);
        }
    }

    public void teamRemove(String teamName, String DNI) {
        Player player = this.playerList.isPlayer(DNI);
        if (this.teamList.existTeam(teamName) && player != null) {
            Team team = this.teamList.isTeam(teamName);
            team.remove(player);
        }
    }

    public void tournamentAdd(String participant, String tournamentName) {
        if ((this.teamList.existTeam(participant) || this.playerList.isPlayer(participant) != null) && (this.tournamentlist.isTournament(tournamentName) != null)) {
            Tournament tournament = this.tournamentlist.isTournament(tournamentName);
            this.tournamentlist.add(tournament);
        }
    }

    public void tournamentCreate(String tournamentName, String startDate, String endDate, String rankingCategory) {

        assert this.tournamentlist.isTournament(tournamentName) == null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        Category category = Category.valueOf(rankingCategory);
        Tournament tournament = new Tournament(tournamentName, start, end, category);
        this.tournamentlist.add(tournament);
    }

    public void tournamentDelete(String tournamentName) {
        assert this.tournamentlist.isTournament(tournamentName) != null;
        Tournament tournament = this.tournamentlist.isTournament(tournamentName);
        this.tournamentlist.remove(tournament);
    }

    public void showShuffleTournamentList() {
        for (Tournament tournament : this.tournamentlist.getTournamentList()) {
            System.out.println(tournament.getTournamentName());
            tournament.showShuffleParticipants();
        }
    }

    public void showTournamentList() {
        for (Tournament tournament : this.tournamentlist.getTournamentList()) {
            System.out.println(tournament.getTournamentName());
            tournament.showRankingParticipants();
        }
    }

    public void removeFinishedTournaments() {
        for (Tournament tournament : this.tournamentlist.getTournamentList()) {
            if (tournament.getEndDate().isBefore(LocalDate.now())) {
                this.tournamentlist.remove(tournament);
            }
        }
    }

    public User isUser(String email, String password) {
        User user = null;
        Admin admin = this.adminList.isAdmin(email, password);
        if (admin == null) {
            user = this.playerList.isPlayer(email, password);
        }
        return user;
    }

    public void tournamentRemove(Player player) {
        assert player != null;
        for (Tournament tournament : this.tournamentlist.getTournamentList()) {
            tournament.remove(player, this.teamList);
        }
    }

    public Participant findParticipant(String key) {
        Participant participant = this.playerList.isPlayer(key);
        if (participant != null) {
            return participant;
        } else {
            participant = this.teamList.isTeam(key);
        }
        return participant;
    }

    public void tournamentMatchmakingManual(String tournamentName, Participant participant1, Participant participant2) {
        Tournament tournament = this.tournamentlist.isTournament(tournamentName);
        if (tournament.areBothCompeting(participant1, participant2)) {
            tournament.matchmake(participant1, participant2);
        }
    }

    public void tournamentMatchmakingAutomatic(String tournamentName) {
        Tournament tournament = this.tournamentlist.isTournament(tournamentName);
        if (tournament.getParticipants().size() % 2 == 0) {
            tournament.randomMatchmake();
        }
    }

    public void statisticsShow(String key, String option) {
        Player player = this.playerList.isPlayer(key);
        if (option.equals("-csv")) {
            player.printTable();
        } else if (option.equals("-json")) {
            player.printJSON();
        }
    }
    public void writeFile(FileWriter writer) throws IOException {
        writePlayerList(writer);
        writeTeamList(writer);
        writeTournamentList(writer);
        writeAdminList(writer);
    }

    private void writePlayerList(FileWriter writer) throws IOException {
        writer.write("Player:\n");
        for (Player player : this.playerList.getPlayerList()) {
            writer.write(String.format("%s;%s;%s;%s;%s\n", player.getForename(),player.getSurname(),player.getKey(),
                    player.getEmail(), player.getPassword()));
        }
    }
    private void writeTeamList(FileWriter writer) throws IOException {
        writer.write("\nTeam:\n");
        for (Team team : this.teamList.getTeamList()) {
            writer.write(String.format("%s;", team.getTeamName()));
            writer.write(String.join(", ", team.getPlayerNames()));
            writer.write("\n");
        }
    }
    private void writeTournamentList(FileWriter writer) throws IOException {
        writer.write("\nTournament:\n");
        for (Tournament tournament : this.tournamentlist.getTournamentList()) {
            writer.write(String.format("%s;%s;%s;%s;", tournament.getTournamentName(), tournament.getStartDate(),
                    tournament.getEndDate(),tournament.getCategory()));
            writer.write(String.join(", ", tournament.getParticipantNames()));
            writer.write("\n");
        }
    }
    private void writeAdminList(FileWriter writer) throws IOException {
        writer.write("\nAdmin:\n");
        for (Admin admin : this.adminList.getAdminList()) {
            writer.write(String.format("%s;%s\n", admin.getEmail(), admin.getPassword()));
        }
    }

    public void readFile(FileReader reader) {

    }


}

