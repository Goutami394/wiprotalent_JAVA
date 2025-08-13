import java.io.*;
import java.util.*;

class DecreaseSeq {

    public class Result {
        public final int output1; // number of decreasing sequences
        public final int output2; // length of longest decreasing sequence

        public Result(int out1, int out2) {
            this.output1 = out1;
            this.output2 = out2;
        }
    }

    public Result decreasingSeq(int[] input1, int input2) {
        int numSequences = 0;
        int longest = 0;
        int currentLength = 1; // start with single element

        for (int i = 0; i < input2 - 1; i++) {
            if (input1[i] > input1[i + 1]) {
                currentLength++;
            } else {
                if (currentLength >= 2) {
                    numSequences++;
                    longest = Math.max(longest, currentLength);
                }
                currentLength = 1; // reset
            }
        }

        // Check if last sequence was decreasing
        if (currentLength >= 2) {
            numSequences++;
            longest = Math.max(longest, currentLength);
        }

        return new Result(numSequences, longest);
    }
}
