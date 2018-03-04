package com.worksafe.disruptthedistrict.worksafe;

import java.util.ArrayList;

/**
 * Created by Adam on 3/4/2018.
 */

public class User {
    private long m_userId;
    private String m_firstName;
    private String m_lastName;
    private String m_username;
    private String m_password;
    private boolean m_admin;
    private ArrayList<Complaint> m_complaints;

    public User() {
        new User(0, "", "", "", "", false, null);
    }

    public User(final long _userId, final String _firstName, final String _lastName,
                final String _username, final String _password, final boolean _admin, final ArrayList<Complaint> _complaints) {
        this.m_userId = _userId;
        this.m_username = _username;
        this.m_password = _password;
        this.m_admin = _admin;
        this.m_complaints = _complaints;
    }

    public long getUserId() {
        return this.m_userId;
    }

    public void setUserId(final long _userId) {
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

    public ArrayList<Complaint> getComplaints() {
        return this.m_complaints;
    }

    public void setComplaints(final ArrayList<Complaint> _complaints) {
        this.m_complaints = _complaints;
    }

    public void addComplaint(final Complaint _complaint) {
        this.m_complaints.add(_complaint);
    }
}
