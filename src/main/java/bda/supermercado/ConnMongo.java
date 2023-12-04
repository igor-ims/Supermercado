package bda.supermercado;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnMongo {
    private static final String MONGODB_URI = "mongodb://localhost:27017/";
    private static final String DATABASE_NAME = "supermercado";

    public static MongoDatabase getMongoDatabase() {
        MongoClient mongoClient = null;
        try {
            MongoClientURI connectionString = new MongoClientURI(MONGODB_URI);
            mongoClient = new MongoClient(connectionString);
            return mongoClient.getDatabase(DATABASE_NAME);
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to MongoDB: " + e.getMessage(), e);
        } finally{
            closeMongoClient(mongoClient);
        }
    }

    public static void closeMongoClient(MongoClient mongoClient) {
        try {
            if (mongoClient != null) {
                mongoClient.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error closing MongoDB client: " + e.getMessage(), e);
        }
    }
    
    public static MongoClient createMongoClient() {
        MongoClientURI connectionString = new MongoClientURI(MONGODB_URI);
        return new MongoClient(connectionString);
    }
    
    public static String getDatabaseName() {
        return DATABASE_NAME;
    }
}
