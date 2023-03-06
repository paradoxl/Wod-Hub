package com.example.wodhub;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.expr;

public class userDAO {
    static MongoCON con = new MongoCON();
    public static void getUserData() {
        try (MongoClient mongoClient = MongoClients.create(con.open())) {
            MongoDatabase database = mongoClient.getDatabase("Users");
            MongoCollection<Document> collection = database.getCollection("userData");
            Document query = new Document();
            query.put("role","Coach");
            FindIterable<Document> cursor = collection.find(query);
            String firstName;
            String lastName;
            String userName;
            String password;
            String role;

            try(final MongoCursor<Document> cursorIterator = cursor.cursor()) {
                while (cursorIterator.hasNext()){
                  firstName = (String) cursorIterator.next().get("First_Name");
                  lastName = (String)  cursorIterator.tryNext().get("Last_Name");
                  password = (String) cursorIterator.tryNext().get("password");
//                  userName = (String) cursorIterator.next().get("username");

//                  role = (String) cursorIterator.next().get("role");
                    System.out.println(firstName);

                }
            }
            catch (Exception e){
                System.out.println("Critical error with cursor");
            }

        }
        catch (Exception e){
            System.out.println("Critical error with connection");
        }

    }
}
