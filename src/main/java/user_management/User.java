package user_management;

import user_management.security.Password;

public class User {

    public int id;
    public String name;
    public String email;
    public Password password;


    public User(int id, String name, String email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = new Password(password);
    }



    @Override
    public String toString() {
        return getName() + " - " + getEmail();
    }

    @Override
    public boolean equals(Object obj) {
        if((obj == null) || (getClass() != this.getClass())){
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(Password password) {
        this.password = password;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }
}
