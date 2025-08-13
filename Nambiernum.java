class Nambiernum {

    public int nnGenerator(String input1) {
        int i = 0;
        StringBuilder nambiarNumber = new StringBuilder();
        int len = input1.length();

        while (i < len) {
            int startDigit = input1.charAt(i) - '0';
            boolean startOdd = (startDigit % 2 != 0);

            int sum = 0;
            while (i < len) {
                int digit = input1.charAt(i) - '0';
                sum += digit;

                boolean sumOdd = (sum % 2 != 0);
                if (sumOdd != startOdd) { 
                    // Parity changed — stop this pass
                    i++;
                    break;
                }
                i++;
            }
            nambiarNumber.append(sum);
        }

        return Integer.parseInt(nambiarNumber.toString());
    }

    public static void main(String[] args) {
        Nambiernum obj = new Nambiernum();
        System.out.println(obj.nnGenerator("9880127431")); // 26971
        System.out.println(obj.nnGenerator("9860857152")); // 3687
        System.out.println(obj.nnGenerator("8123454210")); // 95970
        System.out.println(obj.nnGenerator("9900114279")); // 181149
    }
}

