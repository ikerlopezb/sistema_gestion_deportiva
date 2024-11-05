package upm;

public class Match {
    private Player[] arrayPlayers = new Player[2];

    public Match(Player player1, Player player2) {
        this.arrayPlayers[0] = player1;
        this.arrayPlayers[1] = player2;
    }

    public Player[] getPlayers() {
        return arrayPlayers;
    }
}
