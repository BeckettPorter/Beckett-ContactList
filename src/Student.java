public class Student extends Person {

    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }


    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
