// TypeCastingExample.java

public class TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double variable with a decimal value
        double myDouble = 9.78;

        // Cast the double to an int (explicit casting)
        int myInt = (int) myDouble;
        System.out.println("Double value: " + myDouble);
        System.out.println("After casting double to int: " + myInt);

        // Declare an int variable
        int anotherInt = 42;

        // Cast the int to a double (implicit casting)
        double anotherDouble = anotherInt;
        System.out.println("Int value: " + anotherInt);
        System.out.println("After casting int to double: " + anotherDouble);
    }
}
