package user_management;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;

public class UserCollectionInitializer {

    public static UserCollection generate() throws FileNotFoundException {
        UserCollection userCollection = new UserCollection();
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("/Users/garrettarant/Dev/JavaAssessment3/src/main/resources/users.json"));
        User[] users = gson.fromJson(reader, User[].class);
        Collections.addAll(userCollection, users);
        return userCollection;
    }
}
