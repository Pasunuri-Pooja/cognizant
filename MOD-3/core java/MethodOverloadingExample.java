// MethodOverloadingExample.java

public class MethodOverloadingExample {

    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // Call each overloaded method and display the result
        int sum1 = add(5, 10);               // Two integers
        double sum2 = add(3.5, 4.2);          // Two doubles
        int sum3 = add(1, 2, 3);              // Three integers

        System.out.println("Sum of 5 and 10 (int): " + sum1);
        System.out.println("Sum of 3.5 and 4.2 (double): " + sum2);
        System.out.println("Sum of 1, 2, and 3 (int): " + sum3);
    }
}
