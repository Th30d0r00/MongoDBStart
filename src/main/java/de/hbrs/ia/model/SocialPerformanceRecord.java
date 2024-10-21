package de.hbrs.ia.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class SocialPerformanceRecord {
    private Integer id;
    private Integer salesManId;
    private int year;
    private double LeadershipCompetence;
    private double opennessToEmployees;
    private double socialBehaviorToEmployee;
    private double attitudeTowardsClient;
    private double communicationSkills;
    private double IntegrityToCompany;

    public SocialPerformanceRecord(int id, Integer salesManId, int year, double LeadershipCompetence, double opennessToEmployees, double socialBehaviorToEmployee, double attitudeTowardsClient, double communicationSkills, double IntegrityToCompany) {
        this.id = id;
        this.salesManId = salesManId;
        this.year = year;
        this.LeadershipCompetence = LeadershipCompetence;
        this.opennessToEmployees = opennessToEmployees;
        this.socialBehaviorToEmployee = socialBehaviorToEmployee;
        this.attitudeTowardsClient = attitudeTowardsClient;
        this.communicationSkills = communicationSkills;
        this.IntegrityToCompany = IntegrityToCompany;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(Integer salesManId) {
        this.salesManId = salesManId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLeadershipCompetence() {
        return LeadershipCompetence;
    }

    public void setLeadershipCompetence(double leadershipCompetence) {
        LeadershipCompetence = leadershipCompetence;
    }

    public double getOpennessToEmployees() {
        return opennessToEmployees;
    }

    public void setOpennessToEmployees(double opennessToEmployees) {
        this.opennessToEmployees = opennessToEmployees;
    }

    public double getSocialBehaviorToEmployee() {
        return socialBehaviorToEmployee;
    }

    public void setSocialBehaviorToEmployee(double socialBehaviorToEmployee) {
        this.socialBehaviorToEmployee = socialBehaviorToEmployee;
    }

    public double getAttitudeTowardsClient() {
        return attitudeTowardsClient;
    }

    public void setAttitudeTowardsClient(double attitudeTowardsClient) {
        this.attitudeTowardsClient = attitudeTowardsClient;
    }

    public double getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(double communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public double getIntegrityToCompany() {
        return IntegrityToCompany;
    }

    public void setIntegrityToCompany(double integrityToCompany) {
        IntegrityToCompany = integrityToCompany;
    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("id", this.id);
        document.append("salesManId", this.salesManId);
        document.append("year", this.year);
        document.append("LeadershipCompetence", this.LeadershipCompetence);
        document.append("opennessToEmployees", this.opennessToEmployees);
        document.append("socialBehaviorToEmployee", this.socialBehaviorToEmployee);
        document.append("attitudeTowardsClient", this.attitudeTowardsClient);
        document.append("communicationSkills", this.communicationSkills);
        document.append("IntegrityToCompany", this.IntegrityToCompany);
        return document;
    }
}
