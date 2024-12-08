package upm.utils;

import upm.utils.models.Player;
import upm.utils.models.Admin;

public interface VisitorUser {

    void visit(Player player);

    void visit(Admin admin);

    void tournamentList(Player player);

    void tournamentList(Admin admin);
}
