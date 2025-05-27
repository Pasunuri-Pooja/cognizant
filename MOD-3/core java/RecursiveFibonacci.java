// RecursiveFibonacci.java

import java.util.Scanner;

public class RecursiveFibonacci {
    
    // Recursive method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a positive integer n
        System.out.print("Enter a positive integer (n): ");
        int n = scanner.nextInt();

        // Validate input
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int result = fibonacci(n);
            System.out.println("Fibonacci number at position " + n + " is: " + result);
        }

        scanner.close();
    }
}
