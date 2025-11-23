package com.campus.model;

/**
 *
 * @author  Group2
 * Date     11/2/25
 * Purpose  to have data of user instance when user creates an event in the EventPageController
 */
public class User {
    private String username;
    private String email;


    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     *
     * @return instance username
     */
    public String getUsername() { return username; }

    /**
     *
     *
     * @param username
     */
    public void setUsername(String username) { this.username = username; }

    /**
     *
     *
     * @return instance email
     */
    public String getEmail() { return email; }

    /**
     *
     * @param email
     */
    public void setEmail(String email) { this.email = email; }
}
