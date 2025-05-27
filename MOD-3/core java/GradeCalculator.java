// GradeCalculator.java

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for marks out of 100
        System.out.print("Enter marks (0-100): ");
        int marks = scanner.nextInt();

        // Variable to store the grade
        char grade;

        // Assign grades based on marks
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80 && marks < 90) {
            grade = 'B';
        } else if (marks >= 70 && marks < 80) {
            grade = 'C';
        } else if (marks >= 60 && marks < 70) {
            grade = 'D';
        } else if (marks >= 0 && marks < 60) {
            grade = 'F';
        } else {
            System.out.println("Invalid marks entered.");
            scanner.close();
            return;
        }

        // Display the assigned grade
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
