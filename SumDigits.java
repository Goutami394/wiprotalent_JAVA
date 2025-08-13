import java.io.*;
import java.util.*;

class SumDigits {
    public int sumOfSumsOfDigits(int input1) {
        String numStr = String.valueOf(input1);
        int totalSum = 0;

        for (int i = 0; i < numStr.length(); i++) {
            int partialSum = 0;
            for (int j = i; j < numStr.length(); j++) {
                partialSum += numStr.charAt(j) - '0';
            }
            totalSum += partialSum;
        }

        return totalSum;
    }
}

