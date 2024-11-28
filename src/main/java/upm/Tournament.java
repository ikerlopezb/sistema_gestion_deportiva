package upm;

import upm.model.Player;

import java.util.Date;
import java.util.ArrayList;



public class Tournament {
    private String tournamentName;
    private Date startDate;
    private Date endDate;
    private Category rankingCategory;
    private ArrayList<Player> participants;


    public Tournament(String tournamentName, Date startDate, Date endDate, Category rankingCategory) {
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rankingCategory = rankingCategory;
        this.participants = new ArrayList<>();
    }
}

