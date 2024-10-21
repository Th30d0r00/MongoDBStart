package de.hbrs.ia.code;

import com.mongodb.client.MongoCollection;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

/**
 * Service for interacting with the database
 */

public class ManagePersonalService {

    MongoCollection<Document> salesManCollection;
    MongoCollection <Document> socialPerformanceRecordCollection;
    String uri;
    String databaseName;

    public ManagePersonalService(String uri, String databaseName, String Collection) {
        MongoConnection mongoConnection = MongoConnection.getInstance(uri, databaseName, Collection);
        salesManCollection = mongoConnection.getCollection();
        this.uri = uri;
        this.databaseName = databaseName;

    }

    public void addSalesMan(SalesMan record) {
        salesManCollection.insertOne(record.toDocument());
    }

    public void addSocialPerformanceRecord(SocialPerformanceRecord record, SalesMan salesMan) {
        MongoConnection mongoConnection = MongoConnection.getInstance(uri, databaseName, "socialPerformanceRecord");
        socialPerformanceRecordCollection = mongoConnection.getCollection();
        socialPerformanceRecordCollection.insertOne(record.toDocument());
        int id = record.getId();
        salesManCollection.updateOne(
                eq("sid", salesMan.getId()),
                push("socialPerformanceRecordId", id));
    }

    public List<SocialPerformanceRecord> readSocialPerformanceRecord(SalesMan salesMan) {
        List <Document> Documents = socialPerformanceRecordCollection.find(
                eq("salesManId", salesMan.getId())).into(new ArrayList<>());
        List <SocialPerformanceRecord> socialPerformanceRecords = new ArrayList<>();
        for (Document document : Documents) {
            Integer id = (Integer) document.get("id");
            Integer sid = (Integer) document.get("salesManId");
            Integer year = (Integer) document.get("year");
            Double LeadershipCompetence = (Double) document.get("LeadershipCompetence");
            Double opennessToEmployees = (Double) document.get("opennessToEmployees");
            Double socialBehaviorToEmployee = (Double) document.get("socialBehaviorToEmployee");
            Double attitudeTowardsClient = (Double) document.get("attitudeTowardsClient");
            Double communicationSkills = (Double) document.get("communicationSkills");
            Double IntegrityToCompany = (Double) document.get("IntegrityToCompany");
            SocialPerformanceRecord socialPerformanceRecord = new SocialPerformanceRecord(id, sid, year,
                    LeadershipCompetence, opennessToEmployees, socialBehaviorToEmployee, attitudeTowardsClient,
                    communicationSkills, IntegrityToCompany);
            socialPerformanceRecords.add(socialPerformanceRecord);
        }
        return socialPerformanceRecords;
    }

    public SalesMan readSalesMan(int sid) {
        Document document = salesManCollection.find(new Document("sid", sid)).first();
        if (document == null) {
            return null;
        } else {
            Integer id = (Integer) document.get("sid");
            String firstname = (String) document.get("firstname");
            String lastname = (String) document.get("lastname");
            return new SalesMan(firstname, lastname, id);
        }
    }

    public List<SalesMan> readAllSalesMen() {
        List <Document> Documents = salesManCollection.find().into(new ArrayList<>());
        List <SalesMan> salesManDocuments = new ArrayList<>();
        for (Document document : Documents) {
            Integer id = (Integer) document.get("sid");
            String firstname = (String) document.get("firstname");
            String lastname = (String) document.get("lastname");
            SalesMan salesMan = new SalesMan(firstname, lastname, id);
            salesManDocuments.add(salesMan);
        }
        return salesManDocuments;
    }

    public void updateSalesMan(SalesMan record) {
        salesManCollection.replaceOne(new Document("sid", record.getId()), record.toDocument());
    }

    public void deleteSalesMan(SalesMan record) {
        salesManCollection.deleteOne(new Document("sid", record.getId()));
    }

    public void deleteSocialPerformanceRecord(SocialPerformanceRecord record) {
        socialPerformanceRecordCollection.deleteOne(new Document("salesManId", record.getSalesManId()));
    }


}
