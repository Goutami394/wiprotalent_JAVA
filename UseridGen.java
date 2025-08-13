class UseridGen {

    public String userIdGeneration(String input1, String input2, int input3, int input4) {
        String first = input1;
        String last = input2;
        String pin = String.valueOf(input3);

        String smaller, longer;

        // Step 1: Determine smaller and longer names
        if (first.length() < last.length()) {
            smaller = first;
            longer = last;
        } else if (first.length() > last.length()) {
            smaller = last;
            longer = first;
        } else {
            if (first.compareToIgnoreCase(last) < 0) {
                smaller = first;
                longer = last;
            } else {
                smaller = last;
                longer = first;
            }
        }

        // Step 2: Build initial user ID
        char lastLetter = smaller.charAt(smaller.length() - 1);
        char nthFromLeft = pin.charAt(input4 - 1);
        char nthFromRight = pin.charAt(pin.length() - input4);

        String userId = "" + lastLetter + longer + nthFromLeft + nthFromRight;

        // Step 3: Toggle case
        StringBuilder toggled = new StringBuilder();
        for (char c : userId.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggled.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                toggled.append(Character.toUpperCase(c));
            } else {
                toggled.append(c);
            }
        }

        return toggled.toString();
    }

    // For testing
    public static void main(String[] args) {
        UseridGen obj = new UseridGen();
        System.out.println(obj.userIdGeneration("Rajiv", "Roy", 560037, 6)); // YrAJIV75
        System.out.println(obj.userIdGeneration("Manoj", "Kumar", 561327, 2)); // RmANOJ62
        System.out.println(obj.userIdGeneration("Kumud", "Kumar", 561327, 2)); // RkUMUD62
    }
}
