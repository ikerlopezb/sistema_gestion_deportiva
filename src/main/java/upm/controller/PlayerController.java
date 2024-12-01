package upm.controller;

import upm.list.PlayerList;
import upm.model.Player;
import upm.view.ErrorView;

public class PlayerController {
    private PlayerList playerList;
    private ErrorView error;
    private Player playerlogged; //No sé si es es lo mismo logueado que autenticado.

    public PlayerController(PlayerList playerList) {
        this.playerList = playerList;
    }



}
