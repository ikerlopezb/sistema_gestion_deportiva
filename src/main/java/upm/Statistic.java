package upm;

import java.util.Date;
public class Statistic {
    private Category category;
    private double value;

    public Statistic(Category category, double value) {
        this.category = category;
        this.value = value;
    }
    public Category getCategory() {
        return category;
    }

    public double getValue() {
        return value;
    }
}
