import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static double findMedian(int[] array) {
        int length = array.length;
        if (length % 2 == 0) {
            return (array[length / 2] + array[length / 2 - 1]) / 2.0;
        } else {
            return array[length / 2];
        }
    }

    public static int findHighest(int[] array) {
        return array[array.length - 1];
    }

    public static int findMode(int[] array) {
        int[] counts = new int[findHighest(array) + 1];
        for (int value : array) {
            counts[value]++;
        }
        int mode = 0;
        int maxCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                mode = i;
                maxCount = counts[i];
            }
        }
        return mode;
    }

    public static ArrayList<Integer> findPrimes(int[] array) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int value : array) {
            if (value < 2) {
                continue;
            } else if (value == 2) {
                primes.add(value);
            } else {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(value); i++) {
                    if (value % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(value);
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int[] array = { 47, 84, 75, 21, 14, 14, 79 };
        int[] sortedArray = selectionSort(array);
        double median = findMedian(sortedArray);
        int highest = findHighest(sortedArray);
        int mode = findMode(sortedArray);
        ArrayList<Integer> primes = findPrimes(array);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        System.out.println("Median: " + median);
        System.out.println("Highest value: " + highest);
        System.out.println("Mode: " + mode);
        System.out.println("Primes: " + findPrimes(sortedArray));
    }
}
