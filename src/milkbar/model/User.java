package milkbar.model;

public class User {
    private String email;
    private String name;
    private String password;
    private Authorization authorization;

    public User(String email, String name, String password, Authorization authorization) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.authorization = authorization;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
    public void setAuthorization(String  authorization) {
        if (authorization.equals(Authorization.Admin.toString())) {
            this.authorization = Authorization.Admin;
        }else if (authorization.equals(Authorization.Manager.toString())) {
            this.authorization=Authorization.Manager;
        }
    }
    
}
