import java.io.*;
import java.util.*;

class EncodeStr {

    public class Result {
        public final String output1;
        public final String output2;
        public final String output3;

        public Result(String out1, String out2, String out3) {
            this.output1 = out1;
            this.output2 = out2;
            this.output3 = out3;
        }
    }

    public Result encodeThreeStrings(String input1, String input2, String input3) {
        // Step 1: Split each string
        String[] p1 = splitIntoThree(input1);
        String[] p2 = splitIntoThree(input2);
        String[] p3 = splitIntoThree(input3);

        // Step 2: Concatenate front, middle, end
        String output1 = p1[0] + p2[0] + p3[0];
        String output2 = p1[1] + p2[1] + p3[1];
        String output3 = p1[2] + p2[2] + p3[2];

        // Step 3: Toggle case for output3
        output3 = toggleCase(output3);

        return new Result(output1, output2, output3);
    }

    private String[] splitIntoThree(String s) {
        int len = s.length();
        int rem = len % 3;
        int part = len / 3;

        String front, middle, end;

        if (rem == 0) {
            front = s.substring(0, part);
            middle = s.substring(part, 2 * part);
            end = s.substring(2 * part);
        } else if (rem == 1) {
            front = s.substring(0, part);
            middle = s.substring(part, part + part + 1); // middle gets extra char
            end = s.substring(part + part + 1);
        } else { // rem == 2
            front = s.substring(0, part + 1); // front gets extra char
            middle = s.substring(part + 1, part + 1 + part);
            end = s.substring(part + 1 + part); // end gets extra char
        }

        return new String[]{front, middle, end};
    }

    private String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

    // Example test
    public static void main(String[] args) {
        UserMainCode umc = new UserMainCode();
        Result res = umc.encodeThreeStrings("John", "Johny", "Janardhan");
        System.out.println(res.output1); // JJoJan
        System.out.println(res.output2); // ohhard
        System.out.println(res.output3); // NNYHAN
    }
}

