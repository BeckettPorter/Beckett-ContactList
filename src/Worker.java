public class Worker extends Person {

    // Salary instance variable;
    private int salary;


    // Worker constructor that calls the superclass constructor and then initializes salary
    public Worker(String firstName, String lastName, String phoneNumber, int salary)
    {
        super(firstName, lastName, phoneNumber);
        this.salary = salary;
    }


    // getSalary method
    public int getSalary() {
        return salary;
    }


    // toString override method that adds the salary to the parent's toString
    @Override
    public String toString() {
        return super.toString() + " Salary: " + getSalary();
    }
}
