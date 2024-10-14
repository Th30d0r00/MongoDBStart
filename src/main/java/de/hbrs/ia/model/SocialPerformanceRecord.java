package de.hbrs.ia.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class SocialPerformanceRecord {

    private int id;
    private int year;
    private double teamworkRating;
    private double communicationRating;

    public SocialPerformanceRecord(int id, int year, Double teamworkRating, Double communicationRating) {
        this.id = id;
        this.year = year;
        this.teamworkRating = teamworkRating;
        this.communicationRating = communicationRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTeamworkRating() {
        return teamworkRating;
    }

    public void setTeamworkRating(float teamworkRating) {
        this.teamworkRating = teamworkRating;
    }

    public double getCommunicationRating() {
        return communicationRating;
    }

    public void setCommunicationRating(float communicationRating) {
        this.communicationRating = communicationRating;
    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("SalesManId", this.id);
        document.append("year", this.year);
        document.append("teamworkRating", this.teamworkRating);
        document.append("communicationRating", this.communicationRating);
        return document;
    }
}
