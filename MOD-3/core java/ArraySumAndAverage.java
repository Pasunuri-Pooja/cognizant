// ArraySumAndAverage.java

import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Declare the array
        int[] numbers = new int[n];

        // Read elements into the array
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Calculate the sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Calculate the average
        double average = (double) sum / n;

        // Display the results
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);

        scanner.close();
    }
}
