import java.io.*;
import java.util.*;

class NthElement {

    public int seriesN(int input1, int input2, int input3, int input4) {
        int a = input1;
        int b = input2;
        int c = input3;
        int N = input4;

        // Base cases
        if (N == 1) return a;
        if (N == 2) return b;
        if (N == 3) return c;

        // Calculate differences
        int diff1 = b - a;
        int diff2 = c - b;

        // Start from the 4th element
        int current = c;
        for (int i = 4; i <= N; i++) {
            if (i % 2 == 0) { 
                // Even position after c → add diff2
                current += diff1;
            } else {
                // Odd position after c → add diff2
                current += diff2;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        UserMainCode obj = new UserMainCode();
        
        System.out.println(obj.seriesN(1, 3, 6, 17));  // Output: 41
        System.out.println(obj.seriesN(5, -2, -4, 14)); // Output: -56
    }
}

