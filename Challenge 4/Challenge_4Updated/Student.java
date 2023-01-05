abstract class Student {
    private String firstName;
    private String lastName;
    private String course;

    public Student(String firstName, String lastName, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public abstract int getFinalExam();

    public abstract double getFinalGrade();
}
