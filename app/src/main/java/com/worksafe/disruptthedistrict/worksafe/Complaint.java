package com.worksafe.disruptthedistrict.worksafe;

import java.util.ArrayList;

/**
 * Created by KevinYangMac on 3/3/18.
 */

public class Complaint {
    private String complaintID;
    private String status;
    private String complaintDetails;
    private ArrayList<String> type;

    public Complaint(String complaintID, String status, String complaintDetails){
        this.complaintID = complaintID;
        this.status = status;
        this.complaintDetails = complaintDetails;
    }
    public void setComplaintID(String complaintID){
        this.complaintID = complaintID;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }
    public String getComplaintID(){
        return complaintID;
    }

    public String getStatus(){
        return status;
    }

    public String getComplaintDetails(){
        return  complaintDetails;
    }

    public void addType(String type){
        this.type.add(type);
    }
}
