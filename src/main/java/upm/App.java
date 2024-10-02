package upm;

public class App {

    public static void main(String[] args) {
        AdminView admin = new AdminView();

        Player player1 = new Player("JavierOlmedo");
        Player player2 = new Player("IkerLopez");
        Player player3 = new Player("MarioVicente");

        admin.create(player1);
        admin.create(player2);
        admin.create(player3);

        admin.show();

    }
}
