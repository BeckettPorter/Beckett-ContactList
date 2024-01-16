public class Student extends Person {

    // Grade instance variable
    private int grade;

    // Student constructor that calls the superclass constructor and then initializes grade
    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }


    // getGrade method
    public int getGrade() {
        return grade;
    }

    // toString override method that adds the grade to the parent's toString
    @Override
    public String toString() {
        return super.toString() + " Grade: " + getGrade();
    }
}
