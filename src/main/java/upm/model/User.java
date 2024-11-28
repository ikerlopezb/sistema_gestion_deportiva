package upm.model;

public abstract class User {
    private final String email;
    private final String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public abstract String getRole();

}
