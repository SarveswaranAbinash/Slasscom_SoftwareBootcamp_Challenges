class MathStudent extends Student {
    private double quizAverage;
    private int test1;
    private int test2;
    private int finalExam;

    public MathStudent(String firstName, String lastName, double quizAverage, int test1, int test2, int finalExam) {
        super(firstName, lastName, "Math");
        this.quizAverage = quizAverage;
        this.test1 = test1;
        this.test2 = test2;
        this.finalExam = finalExam;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public double getFinalGrade() {
        return 0.15 * quizAverage + 0.3 * test1 + 0.2 * test2 + 0.35 * finalExam;
    }
}
