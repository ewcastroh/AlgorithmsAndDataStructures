package dynamicprogramming;

public class DPTopDownFibonacci {

    static int[] memo;

    public static int fibonacciTopDownApproach(int number) {
        if (memo[number] != 0) {
            return memo[number];
        } else if (number >= 3) {
            memo[number] = fibonacciTopDownApproach(number - 1) + fibonacciTopDownApproach(number - 2);
        } else {
            return 1;
        }
        return memo[number];
    }

    public static int fibonacci(int number) {
        if (number <= 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Top Down Approach");
        int fibonacciNumber = 6;
        System.out.println("Fibonacci position: " + fibonacciNumber);
        memo = new int[fibonacciNumber + 1];
        System.out.println(fibonacciTopDownApproach(fibonacciNumber));
        System.out.println(fibonacci(fibonacciNumber-1));
    }
}
