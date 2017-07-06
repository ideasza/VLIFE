package teerayut.dev.vlife.authentication.model;

/**
 * Created by OzoeSK on 7/6/2017.
 */

public class AuthenModel {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public AuthenModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthenModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
