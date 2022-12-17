import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Brack_balance_check_answer_2 {

 
    /*
     * Same Stack is Used In the below function but codes and inbuilt functions are
     * used to make the code efficient
     */
    public static boolean bracket_balance_check_2(String s) { // Function Number 2 : used to check wether brackets are balanced

        final String open = "({[", close = ")}]";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            if (open.indexOf(c) != -1)
                stack.push(c);
            else if (stack.isEmpty() || open.indexOf(stack.pop()) != close.indexOf(c))
                return false;
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
            System.out.println(bracket_balance_check_2(input_string));
            
            

        }
    }
}
