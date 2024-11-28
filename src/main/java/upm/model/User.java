package upm.model;

public abstract class User {
    private final String email;
    private final String password;
    public User(String correo, String password) {
        this.email = correo;
        this.password = password;
    }
    public abstract String getRole();

}
