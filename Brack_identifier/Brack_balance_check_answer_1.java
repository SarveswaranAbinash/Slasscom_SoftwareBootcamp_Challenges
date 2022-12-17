import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Brack_balance_check_answer_1 {

    public static boolean bracket_balance_check_1(String s) { // Function used to check wether brackets are balanced
        // Stack to store left symbols

        Stack<Character> leftSymbols = new Stack<>(); // Data Structure Used Stack
        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // If left symbol is encountered
            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.push(c);
            }
            // If right symbol is encountered
            else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
                leftSymbols.pop();
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
                leftSymbols.pop();
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
                leftSymbols.pop();
            }

            // If none of the valid symbols is encountered
            else {
                return false;
            }

        }

        return leftSymbols.isEmpty();
    }

   

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter a String ");
        System.out.println("Hint : Valid Brackets \n 1 - {} \n 2 - [] \n 3 - ()");
        String input_string = sc.nextLine();

        if (input_string.length() == 0) {
            System.out.println("Oops Input Value is empty Enter a String ");

        } else {
            System.out.println(bracket_balance_check_1(input_string));
      

        }
    }
}
