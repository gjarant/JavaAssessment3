package user_management;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import user_management.security.Authenticator;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                return this.get(i);
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEmail().equals(email)) {
                return this.get(i);
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password)  throws UserAuthenticationFailedException {

        User userAttempt = findByEmail(email);

        if(userAttempt.getEmail() == null){
            throw new UserAuthenticationFailedException();
        }
        else if(Authenticator.authenticate(userAttempt, password)){
            return userAttempt;
        }
        else{
            throw new UserAuthenticationFailedException();
        }

    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, PasswordTooSimpleException, InvalidEmailException {
        UserCollection userCollection = new UserCollection();
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("/Users/garrettarant/Dev/JavaAssessment3/src/main/resources/users.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        User[] users = gson.fromJson(reader, User[].class);
        Collections.addAll(userCollection, users);


        

        for(int i = 0; i < userCollection.size(); i++){
            if(userCollection.get(i).getEmail().equals(email)){
                throw new EmailNotAvailableException();
            }
        }



        return 0;
    }


    }
