import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Brack_balance_check_answer_3 {

 

    public static boolean bracket_balance_check_3(String s) { // Function Number 3 : used to check wether brackets are balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        if (s.isEmpty()) {
            return true;
        }

        HashMap<Character, Character> hm = new HashMap<>(); // Data Structure Used HashMap
        hm.put('}', '{');
        hm.put(']', '[');
        hm.put(')', '(');

        LinkedList<Character> ll = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '{' || c == '[' || c == '(') {
                ll.add(c);
            } else {
                if (ll.size() == 0 || ll.removeLast() != hm.get(c)) {
                    return false;
                }
            }
        }

        return ll.size() == 0;
    }

   

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter a String ");
        System.out.println("Hint : Valid Brackets \n 1 - {} \n 2 - [] \n 3 - ()");
        String input_string = sc.nextLine();

        if (input_string.length() == 0) {
            System.out.println("Oops Input Value is empty Enter a String ");

        } else {
            System.out.println(bracket_balance_check_3(input_string));
            

        }
    }
}
