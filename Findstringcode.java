import java.io.*;
import java.util.*;

class UserMainCode {

    public int Findstringcode(String input1) {
        // Convert the string to uppercase for uniform processing
        String[] words = input1.toUpperCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int sum = 0;
            int left = 0;
            int right = word.length() - 1;

            while (left <= right) {
                int leftVal = word.charAt(left) - 'A' + 1;
                int rightVal = word.charAt(right) - 'A' + 1;

                if (left == right) {
                    // Middle character in odd length words
                    sum += leftVal;
                } else {
                    // Absolute difference between positions
                    sum += Math.abs(leftVal - rightVal);
                }

                left++;
                right--;
            }
            // Append the sum for the word to the final result
            result.append(sum);
        }

        // Convert concatenated string to integer
        return Integer.parseInt(result.toString());
    }

    // For quick testing
    public static void main(String[] args) {
        UserMainCode obj = new UserMainCode();
        System.out.println(obj.Findstringcode("World Wide Web"));  // 402326
        System.out.println(obj.Findstringcode("Hello World"));     // 2640
    }
}
