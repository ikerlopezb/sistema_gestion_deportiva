package upm.utils;
import upm.utils.models.Player;
import upm.utils.models.Team;

import java.io.*;

public class ReadTeamList extends Reader {
    private TeamList teamList;
    private PlayerList playerList;
    private final BufferedReader in;

    public ReadTeamList(TeamList teamList, PlayerList playerList, BufferedReader in) {
        super("Team");
        this.teamList = teamList;
        this.in = in;
        this.playerList = playerList;
    }


    public void read(String input) throws IOException {
        if (this.isYours(input)) {
            try (this.in) {
                String linea = this.findLabel(in) + 1;
                while (linea != null && linea.length() > 1) {
                    String[] parts = linea.split(";");
                    String teamName = parts[0].trim();
                    Team team = new Team(teamName);
                    for (int i = 1; i < parts.length; i++) {
                        Player player = this.playerList.isPlayer(parts[i]);
                        team.add(player);
                    }
                    teamList.add(team);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
