import java.io.*;
import java.util.*;

class OccuringDigit {

    public int mostFrequentlyOccurringDigit(int[] input1, int input2) {
        int[] count = new int[10]; // to store frequency of digits 0-9

        // Count occurrences of each digit
        for (int i = 0; i < input2; i++) {
            int num = Math.abs(input1[i]); // handle negative numbers if needed
            if (num == 0) {
                count[0]++;
            }
            while (num > 0) {
                int digit = num % 10;
                count[digit]++;
                num /= 10;
            }
        }

        // Find digit with highest frequency (choose largest if tie)
        int maxFreq = -1;
        int resultDigit = -1;
        for (int digit = 0; digit <= 9; digit++) {
            if (count[digit] > maxFreq || 
               (count[digit] == maxFreq && digit > resultDigit)) {
                maxFreq = count[digit];
                resultDigit = digit;
            }
        }

        return resultDigit;
    }
}
