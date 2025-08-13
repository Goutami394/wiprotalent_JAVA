class DigitRemove {

    public int digitRemove_Palin(int input1) {
        String s = String.valueOf(input1);

        // Already palindrome?
        if (isPalindrome(s)) {
            return -1;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try removing left digit
                String removeLeft = s.substring(0, left) + s.substring(left + 1);
                if (isPalindrome(removeLeft)) {
                    return Character.getNumericValue(s.charAt(left));
                }

                // Try removing right digit
                String removeRight = s.substring(0, right) + s.substring(right + 1);
                if (isPalindrome(removeRight)) {
                    return Character.getNumericValue(s.charAt(right));
                }
            }
            left++;
            right--;
        }

        return -1; // Shouldn't reach here if only one digit is wrong
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        DigitRemove obj = new DigitRemove();
        System.out.println(obj.digitRemove_Palin(12332)); // Expected 1
        System.out.println(obj.digitRemove_Palin(251532)); // Expected 3
        System.out.println(obj.digitRemove_Palin(10101)); // Expected -1
        System.out.println(obj.digitRemove_Palin(981894)); // Expected 4
    }
}
