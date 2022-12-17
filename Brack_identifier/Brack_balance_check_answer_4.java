import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Brack_balance_check_answer_4 {

   
    public static boolean bracket_balance_check_4(String s) { // Function Number 4  : used to check wether brackets are balanced
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>(); // Data Structure Used DeQue_Array
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.peekFirst()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

  

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter a String ");
        System.out.println("Hint : Valid Brackets \n 1 - {} \n 2 - [] \n 3 - ()");
        String input_string = sc.nextLine();

        if (input_string.length() == 0) {
            System.out.println("Oops Input Value is empty Enter a String ");

        } else {
            System.out.println(bracket_balance_check_4(input_string));
        

        }
    }
}
