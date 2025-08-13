import java.io.*;
import java.util.*;

class SampleEncodeArray {

    public class Result {
        public final int output1; // First element of original array
        public final int output2; // Sum of original array

        public Result(int out1, int out2) {
            this.output1 = out1;
            this.output2 = out2;
        }
    }

    public Result findOriginalFirstAndSum(int[] input1, int input2) {
        // Array to store original values
        int[] original = new int[input2];

        // Last element remains unchanged
        original[input2 - 1] = input1[input2 - 1];

        // Decode backwards
        for (int i = input2 - 2; i >= 0; i--) {
            original[i] = input1[i] - original[i + 1];
        }

        // First number in original array
        int firstNumber = original[0];

        // Sum of all numbers in original array
        int sum = 0;
        for (int num : original) {
            sum += num;
        }

        return new Result(firstNumber, sum);
    }
}

