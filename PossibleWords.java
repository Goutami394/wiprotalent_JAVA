import java.util.*;

class PossibleWords {
    public String identifyPossiblewords(String input1, String input2) {
        input1 = input1.toLowerCase();
        String[] words = input2.split(":");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() != input1.length()) continue;

            String lw = word.toLowerCase();
            boolean match = true;

            for (int i = 0; i < lw.length(); i++) {
                char p = input1.charAt(i);
                if (p != '_' && p != lw.charAt(i)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                if (result.length() > 0) result.append(':');
                result.append(word.toUpperCase());
            }
        }

        return result.length() == 0 ? "ERROR-009" : result.toString();
    }
}
