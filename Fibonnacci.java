//Find the fibonacci with recursion
// File: Fibonnacci.java


public class Fibonnacci {
    public static void main(String[] args) {
        int n = 100000; // Number of terms in the Fibonacci series
        System.out.println("Fibonacci Series up to " + n + " terms:");
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

 
