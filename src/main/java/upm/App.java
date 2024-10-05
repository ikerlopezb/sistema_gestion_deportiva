package upm;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        AdminView admin = new AdminView();

        Player player1 = new Player("JavierOlmedo");
        Player player2 = new Player("IkerLopez");
        Player player3 = new Player("MarioVicente");
        Player player4 = new Player("Koke");
        Player player5 = new Player("Josete");
        Player player6 = new Player("Balotelli");
        Player player7 = new Player("Mbappe");
        Player player8 = new Player("Valdivieso");



        admin.create(player1);
        admin.create(player2);
        admin.create(player3);
        admin.create(player4);
        admin.create(player5);
        admin.create(player6);
        admin.create(player7);
        admin.create(player8);

        admin.show();
        System.out.println();
        admin.score(player1, 10);
        admin.score(player2, 7);
        admin.score(player3, 8);
        admin.score(player4, 0);
        admin.score(player5, 80);
        admin.score(player6,7.01);
        admin.score(player7, 99);
        admin.score(player8, 100000000);
        admin.show();
        System.out.println();
        admin.rank();
        System.out.println();
        admin.show();
        System.out.println();
        admin.matchmake(player1.getName(), player2.getName());
        admin.matchmake(player5.getName(), player4.getName());
        System.out.println();
        admin.showMatchmake();
        admin.clearMatchmake();
        admin.randomMatchmake();
        System.out.println();
        admin.showMatchmake();


    }
}
