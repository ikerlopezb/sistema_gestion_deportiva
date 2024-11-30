package upm.model;

import upm.Statistic;
import upm.VisitorUser;
import upm.model.User;

import java.util.ArrayList;

public class Player extends User   {
    private final String forename;
    private final String surname;
    private final String DNI;
    private double score;
    private ArrayList<Statistic> statistics;

    public Player(String forename, String surname,String DNI, String email, String password) {
        super(email, password);
        this.forename = forename;
        this.surname = surname;
        this.DNI = DNI;
        this.score = 0.0;
        this.statistics = new ArrayList<>();
    }

    public String getName() {
        return this.forename;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRole() {
        return "Player";
    }

    public void accept(VisitorUser visitor) {
        visitor.visit(this);
    }

}
