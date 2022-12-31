import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Math extends BaseClass {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public List<String> findGradeAvg(String[] data1) {
        List<String> mathList = new ArrayList<>();
        double finalExam = Double.parseDouble(data1[8]);
        double total = Double.parseDouble(data1[1]) + Double.parseDouble(data1[2]) + Double.parseDouble(data1[3])
                + Double.parseDouble(data1[4]) + Double.parseDouble(data1[5]);
        double total2 = Double.parseDouble(data1[6]);
        double total3 = Double.parseDouble(data1[7]);
        double total4 = Double.parseDouble(data1[8]);
        double average = (total / 500 * 15) + (total2 * 0.3) + (total3 * 0.2) + (total4 * 0.35);
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        mathList.add(String.valueOf(finalExam));
        mathList.add(String.valueOf(average));
        mathList.add(String.valueOf(grade));
        return mathList;
    }
}
