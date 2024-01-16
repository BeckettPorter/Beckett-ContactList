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
                run();

                break;

            case 2:
                System.out.println("Salary: ");
                salary = input.nextInt();
                input.nextLine();

                contacts.add(new Worker(firstName, lastName, phoneNumber, salary));
                run();

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

    public void sort(int sortBy)
    {
        switch (sortBy)
        {
            case 0:
                bubbleSort("firstName");
                break;

            case 1:

                break;

            case 2:

                break;

            default:
                System.out.println("Something messed up if the code got here ???");
        }
    }

    public void bubbleSort(String typeToSort)
    {
        switch (typeToSort)
        {
            case "firstName":
                System.out.println("Sorting first name");

                for (int i = 0; i < contacts.size() - 1; i++)
                {
                    for (int j = 0; j < contacts.size() - i - 2; j++)
                    {
                        if (contacts.get(i).getFirstName().compareTo(contacts.get(j).getFirstName()) > 0)
                        {
                            Person temp = contacts.get(i);
                            contacts.set(i, contacts.get(j));
                            contacts.set(j, temp);
                        }
                    }
                }

                break;

            case "lastName":

                break;

            case "phoneNumber":

                break;

            default:
                System.out.println("Something messed up if the code got to the default case in the bubbleSort method");
        }
    }


    // Searching Methods
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



    public void run()
    {
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

        inputString = input.nextLine();

        switch (inputString)
        {
            case "0":
                break;

            case "1":
                addContact();
                break;

            case "2":

                break;

            case "3":

                break;

            case "4":

                break;

            case "5":
                listStudents();
                break;

            case "6":
                System.out.println("Enter a first name");
                inputString = input.nextLine();
                searchByFirstName(inputString);
                break;

            case "7":
                System.out.println("Enter a last name");
                inputString = input.nextLine();
                searchByLastName(inputString);
                break;

            case "8":
                System.out.println("Enter a Phone Number");
                inputString = input.nextLine();
                searchByPhoneNumber(inputString);
                break;


            default:
                System.out.println("invalid input :/");
        }
    }

}