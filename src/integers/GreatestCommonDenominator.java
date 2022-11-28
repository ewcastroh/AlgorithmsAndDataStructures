package integers;

import java.util.Scanner;

/*
 Find the greatest common denominator(GCM) of two integers.
 Example: GCD of 20 and 6 is 4
 Because 8/4 is 2; and 20/4 is 5

 Applying Euclidean Algorithm
 1. For two integers and b, where a > b, divide a by b.
 2. If the remainder, r, is 0, then stop: GCD is b,
 3. Otherwise, set a to b, b to r, and repeat at step 1 until r is 0.
 */
public class GreatestCommonDenominator {

    public static int greatestCommonDenominator(int valueA, int valueB) {
        while (valueB != 0) {
            int temp = valueA;
            valueA = valueB;
            valueB = temp % valueB;
        }
        return valueA;
    }

    public static void main(String[] args) {
        System.out.println("Greatest Common Denominator of 20 and 8 is: " + greatestCommonDenominator(20, 8));
        System.out.println("Greatest Common Denominator of 60 and 96 is: " + greatestCommonDenominator(60, 96));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value A: ");
        int valueA = scanner.nextInt();
        System.out.print("Enter value B: ");
        int valueB = scanner.nextInt();
        int gcd = greatestCommonDenominator(valueA, valueB);
        String message = String.format("Greatest Common Denominator of %d and %d is: %d", valueA, valueB, gcd);
        System.out.print(message);
    }
}
