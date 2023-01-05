
class ScienceStudent extends Student {
    private int attendance;
    private int project;
    private int midterm;
    private int finalExam;

    public ScienceStudent(String firstName, String lastName, int attendance, int project, int midterm, int finalExam) {
        super(firstName, lastName, "Science");
        this.attendance = attendance;
        this.project = project;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public double getFinalGrade() {
        return 0.1 * attendance + 0.3 * project + 0.3 * midterm + 0.3 * finalExam;
    }
}

