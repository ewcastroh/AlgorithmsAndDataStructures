package recursion;

public class Fibonacci {

    public static int nthFibonacci(int nthNumber) {
        if (nthNumber >= 3) {
            return nthFibonacci(nthNumber - 1) + nthFibonacci(nthNumber - 2);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("5th Fibonacci = " + nthFibonacci(6));
    }
}
