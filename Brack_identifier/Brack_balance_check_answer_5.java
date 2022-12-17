import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

    static boolean bracket_balance_check_5(String expr) {// Function Number 5 : used to check wether brackets are
                                                         // balanced
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();// Data Structure Used DeQue_Array

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char bracket_balance_check_1;
            switch (x) {
                case ')':
                    bracket_balance_check_1 = stack.pop();
                    if (bracket_balance_check_1 == '{' || bracket_balance_check_1 == '[')
                        return false;
                    break;

                case '}':
                    bracket_balance_check_1 = stack.pop();
                    if (bracket_balance_check_1 == '(' || bracket_balance_check_1 == '[')
                        return false;
                    break;

                case ']':
                    bracket_balance_check_1 = stack.pop();
                    if (bracket_balance_check_1 == '(' || bracket_balance_check_1 == '{')
                        return false;
                    break;
            }
        }

        // bracket_balance_check_1 Empty Stack
        return (stack.isEmpty());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter a String ");
        System.out.println("Hint : Valid Brackets \n 1 - {} \n 2 - [] \n 3 - ()");
        String input_string = sc.nextLine();

        if (input_string.length() == 0) {
            System.out.println("Oops Input Value is empty Enter a String ");

        } else {
            System.out.println("Are the Brackets Balanced : " + bracket_balance_check_5(input_string));
        }
    }
}
