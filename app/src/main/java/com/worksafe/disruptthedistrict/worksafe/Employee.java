package com.worksafe.disruptthedistrict.worksafe;

import java.util.ArrayList;

/**
 * Created by KevinYangMac on 3/3/18.
 */

public class Employee {
    private String name;
    private String email;
    private String password;
    private String company;
    private int numComplaints;
    private ArrayList<Complaint> listOfComplaints;
    public Employee(String name, String email, String password, String company){
        this.name = name;
        this.email = email;
        this.password = password;
        this.company = company;
        listOfComplaints = new ArrayList<Complaint>();
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
    public int getNumComplaints(){
        return numComplaints;
    }
    public void setNumComplaints(int numComplaints){
        this.numComplaints = numComplaints;
    }
    public Complaint getComplaint(int i){
        return listOfComplaints.get(i);
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
    public void addComplaint(Complaint complaint){
        listOfComplaints.add(complaint);
    }


}
