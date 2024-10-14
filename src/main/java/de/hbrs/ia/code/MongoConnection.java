package de.hbrs.ia.code;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnection implements AutoCloseable {
    private static MongoConnection instance;
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public MongoConnection(String uri, String databaseName, String collectionName) {

        this.mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase(databaseName);
        this.collection = database.getCollection(collectionName);
    }

    public static MongoConnection getInstance(String uri, String databaseName, String collectionName) {
        if(instance == null) {
            instance = new MongoConnection(uri, databaseName, collectionName);
        }
        return new MongoConnection(uri, databaseName, collectionName);
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @Override
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
