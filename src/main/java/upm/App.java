package upm;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        AdminView admin = new AdminView();

        Player player1 = new Player("Luisa");
        Player player2 = new Player("Manuel");
        Player player3 = new Player("Kurt");
        Player player4 = new Player("Sofia");
        Player player5 = new Player("Robert");

        admin.create(player1);
        admin.create(player2);
        admin.create(player3);
        admin.create(player4);
        admin.create(player5);

        admin.show();
        System.out.println();
        admin.score(player1, 4.5);
        admin.score(player2, 2.7);
        admin.score(player3, 4.0);
        admin.score(player4, 3.8);
        admin.score(player5, 3.8);

        admin.show();
        System.out.println();


    }
}
