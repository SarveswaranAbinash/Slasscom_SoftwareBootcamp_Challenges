import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) throws FileNotFoundException {
        // Read the input file and create a list of student objects
        List<Student> students = readStudentsFromFile("input.txt");

        // Write the summary report to the output file
        writeSummaryReportToFile(students, "report.txt");
    }

    private static List<Student> readStudentsFromFile(String fileName) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));

        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int i = 0; i < numStudents; i++) {
            String nameLine = scanner.nextLine();
            String[] nameParts = nameLine.split(", ");
            String lastName = nameParts[0];
            String firstName = nameParts[1];

            String courseLine = scanner.nextLine();
            String[] courseParts = courseLine.split(" ");
            String course = courseParts[0];
            int[] grades = new int[courseParts.length - 1];
            for (int j = 1; j < courseParts.length; j++) {
                grades[j - 1] = Integer.parseInt(courseParts[j]);
            }

            Student student;
            if (course.equals("English")) {
                student = new EnglishStudent(firstName, lastName, grades[0], grades[1], grades[2]);
            } else if (course.equals("Science")) {
                student = new ScienceStudent(firstName, lastName, grades[0], grades[1], grades[2], grades[3]);
            } else if (course.equals("Math")) {
                int numQuizzes = 5;
                int quizSum = 0;
                for (int j = 0; j < numQuizzes; j++) {
                    quizSum += grades[j];
                }
                double quizAverage = (double) quizSum / numQuizzes;
                student = new MathStudent(firstName, lastName, quizAverage, grades[5], grades[6], grades[7]);
            } else {
                // Unknown course, skip this student
                continue;
            }
            students.add(student);
        }

        return students;
    }

    private static void writeSummaryReportToFile(List<Student> students, String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(fileName));

        // Write the report for each course
        writeSummaryReportForCourse(students, writer, "English");
        writeSummaryReportForCourse(students, writer, "Science");
        writeSummaryReportForCourse(students, writer, "Math");

        // Write the grade distribution for all students
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        int numF = 0;
        for (Student student : students) {
            String letterGrade = getLetterGrade(student.getFinalGrade());
            if (letterGrade.equals("A")) {
                numA++;
            } else if (letterGrade.equals("B")) {
                numB++;
            } else if (letterGrade.equals("C")) {
                numC++;
            } else if (letterGrade.equals("D")) {
                numD++;
            } else if (letterGrade.equals("F")) {
                numF++;
            }
        } // Write the grade distribution to the output file
        writer.println("Grade Distribution");
        writer.println("A: " + numA);
        writer.println("B: " + numB);
        writer.println("C: " + numC);
        writer.println("D: " + numD);
        writer.println("F: " + numF);

        writer.close();
    }

    private static void writeSummaryReportForCourse(List<Student> students, PrintWriter writer, String course) {
        // Filter the list of students to only include those in the specified course
        List<Student> courseStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse().equals(course)) {
                courseStudents.add(student);
            }
        }

        if (courseStudents.isEmpty()) {
            // No students in this course, skip writing the report
            return;
        }

        // Write the heading for the course
        writer.println(course + " Students");
        writer.println("Name\t\tFinal Exam\tFinal Average\tLetter Grade");

        // Write the report for each student in the course
        for (Student student : courseStudents) {
            String name = student.getFirstName() + " " + student.getLastName();
            int finalExam = student.getFinalExam();
            double finalAverage = student.getFinalGrade();
            String letterGrade = getLetterGrade(finalAverage);
            writer.printf("%s\t\t%d\t\t%.2f\t\t%s\n", name, finalExam, finalAverage, letterGrade);
        }

        // Write a blank line between courses
        writer.println();
    }

    private static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

