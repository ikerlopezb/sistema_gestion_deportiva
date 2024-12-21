package upm.utils;

import upm.utils.models.Admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

public class ReadAdminList extends Reader{
    private AdminList adminList;
    private final BufferedReader in;

    public ReadAdminList(AdminList adminList, BufferedReader in){
        super("Admin");
        this.adminList = adminList;
        this.in = in;
    }

    public void read(String input) throws IOException {
        if (this.isYours(input)) {
            try (this.in) {
                String linea = this.findLabel(in) + 1 ;
                while (linea != null && linea.length() > 1) {
                    String[] parts = linea.split(";");
                    if (parts.length == 2) {
                        String email = parts[0].trim();
                        String password = parts[1].trim();
                        Admin admin = new Admin(email,password);
                        adminList.add(admin);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
