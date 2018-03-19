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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Pattern patternEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcherEmail = patternEmail.matcher(email);
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");
        Matcher matcherPassword = patternPassword.matcher(password);

        for(int i = 0; i < userCollection.size(); i++){
            if (!userCollection.get(i).getPassword().equals(matcherPassword.find()) ){
                throw new PasswordTooSimpleException();
            }
            if(userCollection.get(i).getEmail().equals(email)){
                throw new EmailNotAvailableException();
            }
            if (!userCollection.get(i).getEmail().equals(matcherEmail.find())) {
                throw new InvalidEmailException();
            }
            if (!userCollection.get(i).getPassword().equals(matcherPassword.find()) ){
                throw new PasswordTooSimpleException();
            }
        }



        return 0;
    }


    }
