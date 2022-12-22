import java.util.Arrays;
import java.util.Scanner;

public class Challenge_3 {

    public static double Mean(int array[], int number_of_elements) {
        double sum = 0;
        for (int i = 0; i < number_of_elements; i++)
            sum += array[i];

        return sum / (double) number_of_elements;
    }

    // Function for calculating median
    public static double Median(int array[], int number_of_elements) {
        // First we sort the arr
        Arrays.sort(array);

        // check for even case
        if (number_of_elements % 2 != 0)
            return (double) array[number_of_elements / 2];

        return (double) (array[(number_of_elements - 1) / 2] + array[number_of_elements / 2]) / 2.0;
    }

    static int Maximum_Value(int arr[]) {
        int i;

        // Initialize maximum element
        int max = arr[0];

        // Traverse arr elements from second and
        // compare every element with current max
        for (i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    static void primeCount(int array[], int number_of_elements) {
        // Find maximum value in the array
        // .*max_element(arr, arr+n);
        int maximum_element = Arrays.stream(array).max().getAsInt();

        // USE SIEVE TO FIND ALL PRIME NUMBERS LESS
        // THAN OR EQUAL TO maximum_element
        // Create a boolean array "prime[0..n]". A
        // value in prime[i] will finally be false
        // if i is Not a prime, else true.
        Boolean[] prime = new Boolean[maximum_element + 1];
        for (int i = 0; i < maximum_element + 1; i++) {
            prime[i] = true;
        }

        // Remaining part of SIEVE
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= maximum_element; p++) {

            // If prime[p] is not changed, then
            // it is a prime
            if (prime[p] == true) {

                // Update all multiples of p
                for (int i = p * 2; i <= maximum_element; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 0; i < number_of_elements; i++) {
            if (prime[array[i]]) {
                System.out.println(array[i]);
            }
        }

    }

    // Driver code
    public static void main(String args[]) {
        int array[] = { 47, 84, 75, 21, 14, 14, 79 };

        if (array == null) {
            System.out.println("Empty ");
        } else {

            // Function call
            int n = array.length;
            System.out.println("Mean Value  Of the given array is   : " + Mean(array, n));
            System.out.println("Median Value of the given array is  : " + Median(array, n));
            System.out.println("Maximum Value of the given array is : " + Maximum_Value(array));
            System.out.println("Prime-Numbers of the given array    : ");
            primeCount(array, n);

        }
    }

}
