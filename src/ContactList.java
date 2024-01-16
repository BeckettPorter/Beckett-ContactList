import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    private ArrayList<Person> contacts;
    private String inputString;

    private Scanner input = new Scanner(System.in);

    public ContactList()
    {
        inputString = "";
        contacts = new ArrayList<Person>();
    }



    public static void main(String[] args)
    {
        ContactList contactList = new ContactList();
        contactList.run();
    }



    public ArrayList<Person> getContacts() {
        return contacts;
    }




    // Add contact method
    public void addContact()
    {
        int contactType;
        String firstName;
        String lastName;
        String phoneNumber;
        int grade;
        int salary;

        System.out.println("Select a type of contact to add" +
                "\n 1. Student" +
                "\n 2. Worker");
        inputString = input.nextLine();
        switch (inputString)
        {
            case "1":
                contactType = 1;
                break;

            case "2":
                contactType = 2;
                break;

            default:
                contactType = 0;
                System.out.println("Invalid input!");
                return;
        }

        System.out.println("Please fill out the following information.");
        System.out.println("First Name:");
        firstName = input.nextLine();

        System.out.println("Last Name:");
        lastName = input.nextLine();

        System.out.println("Phone Number:");
        phoneNumber = input.nextLine();

        switch (contactType)
        {
            case 1:
                System.out.println("Grade: ");
                grade = input.nextInt();
                input.nextLine();

                contacts.add(new Student(firstName, lastName, phoneNumber, grade));

                break;

            case 2:
                System.out.println("Salary: ");
                salary = input.nextInt();
                input.nextLine();

                contacts.add(new Worker(firstName, lastName, phoneNumber, salary));

                break;

            default:
                System.out.println("How did the code even get here?? (In default switch case of addContact Method)");
        }
    }






    public void printContacts()
    {
        for (Person p : contacts)
        {
            System.out.println(p);
        }
    }



    // List contacts by first name
    public void listByFirstName()
    {
        sort(0);
        printContacts();
    }

    // List contacts by last name
    public void listByLastName()
    {
        sort(1);
        printContacts();
    }

    // List contacts by last name
    public void listByPhoneNumber()
    {
        sort(2);
        printContacts();
    }



    public void sort(int sortBy)
    {
        switch (sortBy)
        {
            case 0:
                bubbleSort("firstName");
                break;

            case 1:
                bubbleSort("lastName");
                break;

            case 2:
                bubbleSort("phoneNumber");
                break;

            default:
                System.out.println("Something messed up if the code got here ???");
        }
    }

    // Bubble sorting method that I can call to sort based off a String "typeToSort"
    public void bubbleSort(String typeToSort)
    {
        // Switches based off the input String and does the correct type of bubble sort(for firstName, lastName, etc.)
        switch (typeToSort)
        {
            case "firstName":
                System.out.println("Sorting first name");

                for (int i = 0; i < contacts.size() - 1; i++)
                {
                    for (int j = 0; j < contacts.size() - i - 1; j++)
                    {
                        if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0)
                        {
                            Person temp = contacts.get(j);
                            contacts.set(j, contacts.get(j + 1));
                            contacts.set(j + 1, temp);
                        }
                    }
                }
                break;


            case "lastName":
                System.out.println("Sorting last name");

                for (int i = 0; i < contacts.size() - 1; i++)
                {
                    for (int j = 0; j < contacts.size() - i - 1; j++)
                    {
                        if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0)
                        {
                            Person temp = contacts.get(j);
                            contacts.set(j, contacts.get(j + 1));
                            contacts.set(j + 1, temp);
                        }
                    }
                }
                break;


            case "phoneNumber":
                System.out.println("Sorting phone number");

                for (int i = 0; i < contacts.size() - 1; i++)
                {
                    for (int j = 0; j < contacts.size() - i - 1; j++)
                    {
                        if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0)
                        {
                            Person temp = contacts.get(j);
                            contacts.set(j, contacts.get(j + 1));
                            contacts.set(j + 1, temp);
                        }
                    }
                }
                break;



            default:
                System.out.println("Default case in bubble sort method (code shouldn't ever get here??)");
        }
    }


    // Searching Methods
    // This method searches through contacts and checks if the input firstName String equals any firstNames in contacts
    public Person searchByFirstName(String firstName)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getFirstName().equals(firstName))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    // This method searches through contacts and checks if the input lastName String equals any lastNames in contacts
    public Person searchByLastName(String lastName)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getLastName().equals(lastName))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    // This method searches through contacts and checks if the input phoneNumber String equals any phone #s in contacts
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return contacts.get(i);
            }
        }
        return null;
    }


    // ListStudents method
    public void listStudents()
    {
        for (Person p : contacts)
        {
            if (p instanceof Student)
            {
                System.out.println(p);
            }
        }
    }



    // Run method which shows list of actions and then calls the correct method based off what the user chooses
    public void run()
    {
        // Print out options menu
        System.out.println("Menu:\n" +
                "1. Add Contact\n" +
                "2. List All Contacts By First Name\n" +
                "3. List All Contacts By Last Name\n" +
                "4. List All Contacts By Phone Number\n" +
                "5. List All Students\n" +
                "6. Search By First Name\n" +
                "7. Search By Last Name\n" +
                "8. Search by Phone Number\n" +
                "0. Exit");

        // Gets user input for what number they choose (could be done with a nextInt but this works too ig)
        inputString = input.nextLine();

        // Main switch statement that switches to the correct response to which number the user puts in
        switch (inputString)
        {
            case "0":
                return;

            case "1":
                addContact();
                break;

            case "2":
                listByFirstName();
                break;

            case "3":
                listByLastName();
                break;

            case "4":
                listByPhoneNumber();
                break;

            case "5":
                listStudents();
                break;

            case "6":
                System.out.println("Enter a first name");
                inputString = input.nextLine();
                System.out.println(searchByFirstName(inputString));
                break;

            case "7":
                System.out.println("Enter a last name");
                inputString = input.nextLine();
                System.out.println(searchByLastName(inputString));
                break;

            case "8":
                System.out.println("Enter a Phone Number");
                inputString = input.nextLine();
                System.out.println(searchByPhoneNumber(inputString));
                break;


            default:
                System.out.println("invalid input :/");
        }
        // Call run again to allow the user to do something else
        run();
    }

}