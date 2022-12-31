import java.util.ArrayList;
import java.util.List;
import java.math.*;
import java.text.DecimalFormat;

public class English extends BaseClass {
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public List<String> findGradeAvg(String[] data1) {
        List<String> englishList = new ArrayList<>();
        double finalExam = Double.parseDouble(data1[3]);
        double total = Double.parseDouble(data1[1]) ;
        double total2 = Double.parseDouble(data1[2]) ;
        double total3 =   Double.parseDouble(data1[3]);
        double average =  (total * 0.3) + (total2 *  0.3) + (finalExam * 0.4) ;
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
        englishList.add(String.valueOf(finalExam));
        englishList.add(String.valueOf(average));
        englishList.add(String.valueOf(grade));
        return englishList;
    }
}
