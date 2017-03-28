package org.launchcode.models;

/**
 * Created by Laura on 3/27/2017.
 */
public class User {
    private String username;
    private String email;
    private String password;
    private int userId;

    int getNextUserId = 1;

    public String getUsername() {
        return username;
    }

    public User(){
        this.userId = getNextUserId;
        getNextUserId++;
    }
    public User (String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGetNextUserId() {
        return getNextUserId;
    }

    public void setGetNextUserId(int getNextUserId) {
        this.getNextUserId = getNextUserId;
    }
}
