package dynamicprogramming;

public class DPBottomUpFibonacci {

    private static int[] memo;

    public static int fibonacciBottomUpApproach(int number) {
        int[] output = new int[number + 1];
        output[1] = 1;
        output[2] = 1;
        for (int i = 3; i <= number; i++) {
            output[i] = output[i - 1] + output[i - 2];
        }
        return output[number];
    }

    public static int fibonacci(int number) {
        if (number <= 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Top Down Approach");
        int fibonacciNumber = 8;
        System.out.println("Fibonacci position: " + fibonacciNumber);
        memo = new int[fibonacciNumber + 1];
        System.out.println(fibonacciBottomUpApproach(fibonacciNumber));
        System.out.println(fibonacci(fibonacciNumber-1));
    }
}
