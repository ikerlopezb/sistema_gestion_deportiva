package upm.utils;

import java.util.ArrayList;

import upm.utils.models.Admin;

import java.util.Iterator;

public class AdminList {

    private ArrayList<Admin> adminList = new ArrayList<>();


    public AdminList() {
        adminList.add(new Admin("luis.fernandezm@upm.es", "1234"));
        adminList.add(new Admin("j.benal@upm.es", "1234"));
        adminList.add(new Admin("j.galloso@upm.es", "1234"));
        adminList.add(new Admin("andrejesus.cimmino@upm.es", "1234"));
    }

    public Admin isAdmin(String email, String password) {
        Iterator<Admin> iterator = this.adminList.iterator();
        Admin adminInList = iterator.next();

        while (!adminInList.getEmail().equals(email) &&
                !adminInList.getPassword().equals(password) && iterator.hasNext()) {
            adminInList = iterator.next();
        }
        return (adminInList.getEmail().equals(email) &&
                adminInList.getPassword().equals(password)) ? adminInList : null;
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }
}
