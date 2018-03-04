package com.worksafe.disruptthedistrict.worksafe;

/**
 * Created by Adam on 3/4/2018.
 */

public class User {
    private int m_userId;
    private String m_firstName;
    private String m_lastName;
    private String m_username;
    private String m_password;
    private boolean m_admin;

    public User() {
        new User(0, "", "", "", "", false);
    }

    public User(final int _userId, final String _firstName, final String _lastName,
                final String _username, final String _password, final boolean _admin) {
        this.m_userId = _userId;
        this.m_username = _username;
        this.m_password = _password;
        this.m_admin = _admin;
    }

    public int getUserId() {
        return this.m_userId;
    }

    public void setUserId(final int _userId) {
        this.m_userId = _userId;
    }

    public String getFirstName() {
        return this.m_firstName;
    }

    public void setFirstName(final String _firstName) {
        this.m_firstName = _firstName;
    }

    public String getLastName() {
        return this.m_lastName;
    }

    public void setLastName(final String _lastName) {
        this.m_lastName = _lastName;
    }

    public String getUsername() {
        return this.m_username;
    }

    public void setUsername(final String _username) {
        this.m_username = _username;
    }

    public String getPassword() {
        return this.m_password;
    }

    public void setPassword(final String _password) {
        this.m_password = _password;
    }

    public  boolean getAdmin() {
        return this.m_admin;
    }

    public void setAdmin(final boolean _admin) {
        this.m_admin = _admin;
    }
}
