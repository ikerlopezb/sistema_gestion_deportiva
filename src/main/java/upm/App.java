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

        System.out.println("Jugadores dados de alta");
        admin.create(player1);
        admin.create(player2);
        admin.create(player3);
        admin.create(player4);
        admin.create(player5);
        admin.show();

        System.out.println();

        System.out.println("Establecer puntuacion");
        admin.score(player1, 4.5);
        admin.score(player2, 2.7);
        admin.score(player3, 4.0);
        admin.score(player4, 3.8);
        admin.score(player5, 3.8);
        admin.show();

        System.out.println();
        System.out.println("Baja jugador 5");
        admin.remove(player5.getName());
        admin.show();

        System.out.println();

        System.out.println("Rankear jugadores");
        admin.rank();
        admin.show();

        System.out.println();

        System.out.println("Generar emparejamientos aleatorios y mostrarlos");
        admin.randomMatchmake();
        admin.showMatchmake();

        System.out.println();

        System.out.println("Borrar emparejamientos... \n");
        admin.clearMatchmake();
        admin.showMatchmake();

        System.out.println("Crear un emparejamiento y mostrarlo");
        admin.matchmake(player1.getName(),player2.getName());
        admin.showMatchmake();


    }
}
