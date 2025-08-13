import java.util.*;

class Findpass {

    public int findPassword(int input1, int input2, int input3, int input4, int input5) {
        int[] nums = {input1, input2, input3, input4, input5};
        int stableSum = 0;
        int unstableSum = 0;

        for (int num : nums) {
            if (isStable(num)) {
                stableSum += num;
            } else {
                unstableSum += num;
            }
        }

        return stableSum - unstableSum;
    }

    private boolean isStable(int num) {
        String s = String.valueOf(num);
        int[] freq = new int[10];

        // Count digit frequencies
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }

        // Find the first non-zero frequency
        int expectedFreq = 0;
        for (int f : freq) {
            if (f > 0) {
                expectedFreq = f;
                break;
            }
        }

        // Check if all non-zero frequencies match expectedFreq
        for (int f : freq) {
            if (f > 0 && f != expectedFreq) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Findpass obj = new Findpass();
        System.out.println(obj.findPassword(12, 1313, 122, 678, 898)); // Expected: 983
    }
}

