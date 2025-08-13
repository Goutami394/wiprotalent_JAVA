import java.io.*;
import java.util.*;

class SumPower {
    public int sumOfPowerOfDigits(int input1) {
        String numStr = String.valueOf(input1);
        int sum = 0;

        for (int i = 0; i < numStr.length(); i++) {
            int base = numStr.charAt(i) - '0';
            int exponent;

            if (i < numStr.length() - 1) {
                exponent = numStr.charAt(i + 1) - '0';
            } else {
                exponent = 0; // last digit raised to power 0
            }

            sum += (int) Math.pow(base, exponent);
        }

        return sum;
    }
}
