package comp1112proje2;

import java.util.Random;

public class IndividualCustomer extends Customer {

    private String gender;
    private String identity;
    private String occupation;

    IndividualCustomer() {
    }

    // Constructor
    public IndividualCustomer(String name, String address, long phoneNumber, String email,String gender, String occupation) {

        super(name, address, phoneNumber, email);
        this.gender = gender;
        this.identity = generateRandomID();
        this.occupation = occupation;

    }

    // Generates a random 11-digit number as a string
    private String generateRandomID() {
        Random rand = new Random();
        long number = (long) (rand.nextDouble() * 100000000000L);
        return String.format("%011d", number);
    }

    // Getters and setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentity() {
        return identity;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Method to print customer information
    public String toString() {
        return "Name: " + getName() + "\n"
                + "Address: " + getAdress() + "\n"
                + "Phone Number: " + getPhoneNumber() + "\n"
                + "Email: " + getMail() + "\n"
                + "Identity Number: " + identity + "\n"
                + "Occupation: " + occupation+""
                + "\nGender:"+gender
                ;

    }
}
