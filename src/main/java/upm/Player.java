package upm;

public class Player {
    private final String name;
    private double score;

    public Player(String name) {
        this.name = name;
        this.score = 0.0;
    }


    public String getName() {
        return this.name;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
