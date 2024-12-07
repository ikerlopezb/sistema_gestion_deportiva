package upm.model;

import upm.Category;
import upm.Statistic;
import upm.VisitorUser;
import upm.model.User;

import java.util.ArrayList;
import java.util.Iterator;

public class Player extends User implements Participant   {
    private final String forename;
    private final String surname;
    private final String DNI;
    private ArrayList<Statistic> statistics;

    public Player(String forename, String surname,String DNI, String email, String password) {
        super(email, password);
        this.forename = forename;
        this.surname = surname;
        this.DNI = DNI;
        this.statistics = new ArrayList<>();
    }

    public ArrayList<Statistic> getStatistics() {
        return statistics;
    }

    public String getDNI(){
        return this.DNI;
    }
    public String getName() {
        return this.forename;
    }

    public String getRole() {
        return "Player";
    }

    public void accept(VisitorUser visitor) {
        visitor.visit(this);
    }

    public void tournamentList(VisitorUser visitor) {
        visitor.tournamentList(this);
    }
    public double getRank(Category category){
        Iterator<Statistic> iterator = this.statistics.iterator();
        Statistic statistic = iterator.next();
        while(statistic.getCategory().equals(category) && iterator.hasNext()){
            statistic = iterator.next();
        }
        return statistic.getValue();
    }
}
