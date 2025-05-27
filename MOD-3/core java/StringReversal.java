// StringReversal.java

import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        // Method 1: Using StringBuilder (simple and efficient)
        String reversed1 = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed using StringBuilder: " + reversed1);

        // Method 2: Using a loop (manual method)
        String reversed2 = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed2 += input.charAt(i);
        }
        System.out.println("Reversed using loop: " + reversed2);

        scanner.close();
    }
}
