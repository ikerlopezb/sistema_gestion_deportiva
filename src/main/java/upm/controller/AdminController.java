package upm.controller;

import java.util.ArrayList;
import upm.model.Admin;

public class AdminController {

    private ArrayList<Admin> adminList = new ArrayList<>();

    public AdminController() {
        adminList.add(new Admin("luis.fernandezm@upm.es", "1234"));
        adminList.add(new Admin("j.benal@upm.es", "1234"));
        adminList.add(new Admin("j.galloso@upm.es", "1234"));
        adminList.add(new Admin("andrejesus.cimmino@upm.es", "1234"));
    }
}
