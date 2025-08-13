import java.util.*;

class UserMainCode {

    public String AddNumberString(String input1, String input2) {
        // Step 1: Reverse both strings to start addition from the last digit
        StringBuilder num1 = new StringBuilder(input1).reverse();
        StringBuilder num2 = new StringBuilder(input2).reverse();

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(num1.length(), num2.length());

        // Step 2: Add digits one by one
        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length()) ? num1.charAt(i) - '0' : 0;
            int digit2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);  // store the last digit of sum
            carry = sum / 10;         // update carry
        }

        // Step 3: If carry remains, append it
        if (carry > 0) {
            result.append(carry);
        }

        // Step 4: Reverse the result back to correct order
        return result.reverse().toString();
    }

    // For quick testing
    public static void main(String[] args) {
        UserMainCode obj = new UserMainCode();
        System.out.println(obj.AddNumberString("1234", "56")); // Output: 1290
        System.out.println(obj.AddNumberString("56", "1234")); // Output: 1290
        System.out.println(obj.AddNumberString("123456732128989543219", "987612673489652"));
        // Output: 123457719741663032871
    }
}
