package upm;
import upm.model.Admin;
import upm.model.Player;
import java.util.List;

public class LoginVisitor implements VisitorUser{

    private List<String> enabledCommands;
    public void visit(Player player){
        enabledCommands = List.of("tournament-add","tournament-remove","statistics-show","login","logout",
                "tournament-list");
    }
    public void visit(Admin admin){
        enabledCommands = List.of("player-create","team-create","player-delete","team-delete","team-add","team-remove",
                "tournament-create","tournament-delete","tournament-matchmaking","login","logout","tournament-list");
    }

}
