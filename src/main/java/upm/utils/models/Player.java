package upm.utils.models;

import upm.utils.Category;
import upm.utils.Statistic;
import upm.utils.VisitorUser;

import java.util.ArrayList;
import java.util.Iterator;

public class Player extends User implements Participant {
    private final String forename;
    private final String surname;
    private final String key;
    private ArrayList<Statistic> statistics;
    private boolean inTeam;

    public Player(String forename, String surname, String key, String email, String password) {
        super(email, password);
        this.forename = forename;
        this.surname = surname;
        this.key = key;
        this.statistics = new ArrayList<>();
        this.inTeam = false;
    }

    public ArrayList<Statistic> getStatistics() {
        return statistics;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isInTeam() {
        return inTeam;
    }

    public void setInTeam(boolean inTeam) {
        this.inTeam = inTeam;
    }

    public void accept(VisitorUser visitor) {
        visitor.visit(this);
    }

    public void tournamentList(VisitorUser visitor) {
        visitor.tournamentList(this);
    }

    public double getRank(Category category) {
        Iterator<Statistic> iterator = this.statistics.iterator();
        Statistic statistic = iterator.next();
        while (statistic.getCategory().equals(category) && iterator.hasNext()) {
            statistic = iterator.next();
        }
        return statistic.getValue();
    }

    public Player asPlayer() {
        return this;
    }

    public Participant isParticipant(String key) {
        if (this.getKey().equals(key)) {
            return this;
        }
        return null;
    }

    public void printTable() {
        System.out.println("+------------------+----------------+");
        System.out.printf("| %-16s | %-14s |\n", "Categoria", "Valor");
        System.out.println("+------------------+----------------+");

        Iterator<Statistic> iterator = this.getStatistics().iterator();
        while (iterator.hasNext()) {
            Statistic statistic = iterator.next();
            System.out.printf("| %-16 | %-14f |\n", statistic.getCategory(), statistic.getValue());
        }
        System.out.println("+------------------+----------------+");
    }

    public void printJSON() {
        Iterator<Statistic> iterator = this.getStatistics().iterator();
        while (iterator.hasNext()) {
            Statistic statistic = iterator.next();
            System.out.println(statistic.getCategory() + " : " + statistic.getValue());
        }
    }


}
