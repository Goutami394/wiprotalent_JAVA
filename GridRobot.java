class GridRobot {
    public String moveRobot(int input1, int input2, String input3, String input4) {
        // Parse starting position
        String[] startParts = input3.split("-");
        int x = Integer.parseInt(startParts[0]);
        int y = Integer.parseInt(startParts[1]);
        char dir = startParts[2].charAt(0);

        // Split movement instructions (space separated)
        String[] instructions = input4.trim().split("\\s*");

        // Direction array for easy turning
        char[] directions = {'N', 'E', 'S', 'W'};
        int dirIndex = 0;
        for (int i = 0; i < 4; i++) {
            if (directions[i] == dir) {
                dirIndex = i;
                break;
            }
        }

        // Process instructions
        for (char command : input4.toCharArray()) {
            if (command == 'L') {
                dirIndex = (dirIndex + 3) % 4; // Turn left
            } else if (command == 'R') {
                dirIndex = (dirIndex + 1) % 4; // Turn right
            } else if (command == 'M') {
                int newX = x;
                int newY = y;
                if (directions[dirIndex] == 'N') newY++;
                else if (directions[dirIndex] == 'S') newY--;
                else if (directions[dirIndex] == 'E') newX++;
                else if (directions[dirIndex] == 'W') newX--;

                // Check grid bounds
                if (newX < 0 || newY < 0 || newX > input1 || newY > input2) {
                    return x + "-" + y + "-" + directions[dirIndex] + "-ER";
                } else {
                    x = newX;
                    y = newY;
                }
            }
        }

        return x + "-" + y + "-" + directions[dirIndex];
    }

    // For testing
    public static void main(String[] args) {
        GridRobot robot = new GridRobot();
        System.out.println(robot.moveRobot(3, 3, "2-2-E", "RMLMLM")); // 3-2-N
        System.out.println(robot.moveRobot(3, 4, "2-2-E", "RMLMLMRM")); // 3-2-E-ER
    }
}

