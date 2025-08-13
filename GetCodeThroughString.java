import java.util.*;

class UserMainCode {

    public int GetCodeThroughString(String input1) {
        // Step 1: Split the string into words
        String[] words = input1.trim().split("\\s+");

        // Step 2: Calculate total length of all words
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }

        // Step 3: Reduce to single digit by summing digits repeatedly
        while (totalLength >= 10) {
            int sum = 0;
            while (totalLength > 0) {
                sum += totalLength % 10;
                totalLength /= 10;
            }
            totalLength = sum;
        }

        return totalLength; // Final single-digit numeric PIN
    }

    // For quick testing
    public static void main(String[] args) {
        UserMainCode obj = new UserMainCode();
        System.out.println(obj.GetCodeThroughString("Wipro Technologies")); // Output: 8
        System.out.println(obj.GetCodeThroughString("The Good The Bad and The Ugly")); // Output: 5
    }
}
