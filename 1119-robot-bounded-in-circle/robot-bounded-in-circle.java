class Solution {
    public boolean isRobotBounded(String instructions) {
        // Initial position of the robot
        int x = 0;
        int y = 0;
        
        // Initial direction of the robot (facing upward)
        int dirX = 0;
        int dirY = 1;

        // Iterating through the instructions
        for (char direction : instructions.toCharArray()) {
            if (direction == 'G') {
                // Moving forward based on the current direction
                x = x + dirX;
                y = y + dirY;
            } else if (direction == 'L') {
                // Turning left by swapping and negating direction components
                int temp = dirX;
                dirX = -dirY;
                dirY = temp;
            } else {
                // Turning right by swapping and negating direction components
                int temp = dirX;
                dirX = dirY;
                dirY = -temp;
            }
        }

        // Checking if the robot is back to the starting position or not facing upward
        return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);
    }
}
