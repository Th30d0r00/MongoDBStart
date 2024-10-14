package de.hbrs.ia.model;


import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class SalesMan {
    private String firstname;
    private String lastname;
    private Integer sid;
    private ArrayList<Integer> socialPerformanceRecordId;

    public SalesMan(String firstname, String lastname, Integer sid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.sid = sid;
        this.socialPerformanceRecordId = new ArrayList<>();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return sid;
    }

    public void setId(Integer sid) {
        this.sid = sid;
    }

    public ArrayList<Integer> getSocialPerformanceRecordId() {
        return socialPerformanceRecordId;
    }

    public void setSocialPerformanceRecordIds(ArrayList<Integer> socialPerformanceRecordId) {
        this.socialPerformanceRecordId = socialPerformanceRecordId;
    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("firstname" , this.firstname );
        document.append("lastname" , this.lastname );
        document.append("sid" , this.sid);
        return document;
    }
}
