import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Science extends BaseClass {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public List<String> findGradeAvg(String[] data1) {
        List<String> scienceList = new ArrayList<>();
        double finalExam = Double.parseDouble(data1[4]);
        double total = Double.parseDouble(data1[1]) ;
        double total2 =  Double.parseDouble(data1[2]) ;
        double total3 = Double.parseDouble(data1[3]) ; 
        double total4 =  Double.parseDouble(data1[4]) ;
        double average = ((total * 0.1) + (total2 * 0.3) +(total3 * 0.3) + (total4 * 0.3));
        char grade;
        if (average > 90) {
            grade = 'A';
        } else if (average > 80) {
            grade = 'B';
        } else if (average > 70) {
            grade = 'C';
        } else if (average > 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        scienceList.add(String.valueOf(finalExam));
        scienceList.add(String.valueOf(average));
        scienceList.add(String.valueOf(grade));
        return scienceList;
    }
}
