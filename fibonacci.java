
import java.util.Scanner;

public class fibonacci {

    // Recursive method
    static int fibRecursive(int n) {
        if (n <= 1)
            return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Non-recursive method
    static void fibNonRecursive(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }

        System.out.println("\nNon-Recursive Fibonacci:");
        fibNonRecursive(n);

        sc.close();
    }
}
































































































































/*
 * THEORY:
 * 
 * The Fibonacci series is a sequence of numbers in which each number
 * is the sum of the previous two numbers. The series starts with 0 and 1.
 * 
 * Example:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
 * 
 * Formula:
 * F(n) = F(n-1) + F(n-2)
 * 
 * Where:
 * F(0) = 0
 * F(1) = 1
 * 
 * 1. Recursive Method:
 * Recursion is a programming technique in which a function calls
 * itself to solve a problem. In Fibonacci, the function calls itself
 * to calculate the previous two numbers. It uses base conditions
 * to stop the recursive calls.
 * 
 * 2. Non-Recursive Method:
 * The non-recursive method uses loops instead of function calls.
 * It stores the previous two numbers in variables and calculates
 * the next number by adding them.
 * 
 * 3. Time Complexity:
 * Time complexity represents the time required by an algorithm
 * as the input size increases.
 * 
 * 4. Space Complexity:
 * Space complexity represents the extra memory required by
 * an algorithm during execution.
 * 
 * Complexity Analysis:
 * 
 * Recursive Method:
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 * 
 * Non-Recursive Method:
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * The recursive method takes more time because it repeats
 * calculations. The non-recursive method is faster because it
 * calculates each number once using a loop.
 * 
 * Applications:
 * 1. Mathematical calculations.
 * 2. Understanding recursion and iteration.
 * 3. Algorithm analysis.
 * 4. Programming practice.
 * 
 * Conclusion:
 * The Fibonacci series can be generated using both recursive
 * and non-recursive methods. Both produce the same sequence,
 * but the non-recursive method is more efficient in terms of
 * time and space complexity.
 */