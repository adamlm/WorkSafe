package com.worksafe.disruptthedistrict.worksafe;

/**
 * Created by KevinYangMac on 3/3/18.
 */

public class Admin {
    private String name;
    private String email;
    private String password;
    private String company;
    public Admin(String name, String email, String password, String company){
        this.name = name;
        this.email = email;
        this.password = password;
        this.company = company;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getCompany(){
        return company;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public void updateIssueStatus(Complaint complaint, String status){
        //complaint.setStatus(status);
    }
}
