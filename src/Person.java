public class Person {

    // Person instance variables
    private String firstName;
    private String lastName;
    private String phoneNumber;


    // Constructor that initializes firstName, lastName, and phoneNumber
    public Person(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    // Getter methods for firstName, lastName, and phoneNumber
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    // toString method that prints the firstName, lastName, and phoneNumber in a formatted way
    @Override
    public String toString() {
        return firstName + lastName + " - #" + phoneNumber;
    }
}
