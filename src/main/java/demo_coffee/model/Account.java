package demo_coffee.model;

public class Account {
    private int idUser ;
    private String username ;
    private String password ;
    private String permission ;
    private boolean status ;

    public Account(){}

    public Account(int idUser, String username, String password, String permission, boolean status) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
