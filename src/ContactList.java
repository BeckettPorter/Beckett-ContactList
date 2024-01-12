import java.util.ArrayList;

public class ContactList {

    private ArrayList<Person> contacts;

    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }



    public static void main(String[] args)
    {

    }



    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person personToAdd)
    {
        contacts.add(personToAdd);
    }
}