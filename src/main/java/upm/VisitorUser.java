package upm;

import upm.model.Player;
import upm.model.Admin;

public interface VisitorUser {

    void visit(Player player);
    void visit(Admin admin);
}
