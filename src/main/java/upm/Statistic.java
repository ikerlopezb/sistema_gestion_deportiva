package upm;

import java.util.Date;
public class Statistic {
    private Category category;
    private double value;
    private Date tournamentDate;

    public Statistic(Category category, double value, Date tournamentDate) {
        this.category = category;
        this.value = value;
        this.tournamentDate = tournamentDate;
    }

}
