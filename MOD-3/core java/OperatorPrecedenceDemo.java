// OperatorPrecedenceDemo.java

public class OperatorPrecedenceDemo {
    public static void main(String[] args) {
        // Expression 1: Multiplication has higher precedence than addition
        int result1 = 10 + 5 * 2;  // 5 * 2 = 10, then 10 + 10 = 20
        System.out.println("Result of 10 + 5 * 2 = " + result1);

        // Expression 2: Parentheses change the evaluation order
        int result2 = (10 + 5) * 2; // (10 + 5) = 15, then 15 * 2 = 30
        System.out.println("Result of (10 + 5) * 2 = " + result2);

        // Expression 3: Combination of addition, multiplication, and division
        int result3 = 20 / 4 + 3 * 2; 
        // Division and multiplication have same precedence, evaluated left to right
        // 20 / 4 = 5, 3 * 2 = 6, then 5 + 6 = 11
        System.out.println("Result of 20 / 4 + 3 * 2 = " + result3);

        // Expression 4: Mixed operators with subtraction and modulus
        int result4 = 15 - 4 % 3 * 2;
        // Modulus (%) and multiplication (*) evaluated first: 4 % 3 = 1, then 1 * 2 = 2
        // Then subtraction: 15 - 2 = 13
        System.out.println("Result of 15 - 4 % 3 * 2 = " + result4);
    }
}
