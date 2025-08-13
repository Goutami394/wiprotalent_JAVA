import java.util.*;
class NotPrime {

    public int sumOfNonPrimeIndexValues(int[] input1, int input2) {
        int sum = 0;
        for (int i = 0; i < input2; i++) {
            if (!isPrime(i)) {  // If index is non-prime
                sum += input1[i];
            }
        }
        return sum;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;   // 0 and 1 are not prime
        if (n == 2) return true;    // 2 is prime
        if (n % 2 == 0) return false; // even numbers > 2 are not prime
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NotPrime obj = new NotPrime();

        int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println(obj.sumOfNonPrimeIndexValues(arr1, arr1.length)); // Expected: 340

        int[] arr2 = {-1, -2, -3, 3, 4, -7};
        System.out.println(obj.sumOfNonPrimeIndexValues(arr2, arr2.length)); // Expected: 1

        int[] arr3 = {-4, -2};
        System.out.println(obj.sumOfNonPrimeIndexValues(arr3, arr3.length)); // Expected: -6
    }
}

