package upm.list;

import java.util.ArrayList;
import upm.model.Admin;
import java.util.Iterator;

public class AdminList {

    private ArrayList<Admin> adminList = new ArrayList<>();


    public AdminList() {
        adminList.add(new Admin("luis.fernandezm@upm.es", "1234"));
        adminList.add(new Admin("j.benal@upm.es", "1234"));
        adminList.add(new Admin("j.galloso@upm.es", "1234"));
        adminList.add(new Admin("andrejesus.cimmino@upm.es", "1234"));
    }

    public boolean isAdmin (String email, String password) {
        Iterator<Admin> iterator = adminList.iterator();
        Admin adminInList =  iterator.next();

        while (!adminInList.getEmail().equals(admin.getEmail()) &&
                !adminInList.getPassword().equals(admin.getPassword()) && iterator.hasNext()) {
            adminInList = iterator.next();
        }
        return adminInList.getEmail().equals(admin.getEmail()) &&
                adminInList.getPassword().equals(admin.getPassword());
    }


}
