package net.oviedo.backendjava.models.requests.responses;

public class UserRest {

    private String userId; // id (Publico) Sin auto increment, this will be a unique identifier for the user
    private String firstName;
    private String lastName;
    private String email;
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}


