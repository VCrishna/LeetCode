class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dirX = 0;
        int dirY = 1;

        for (char direction : instructions.toCharArray()) {
            if (direction == 'G') {
                x = x + dirX;
                y = y + dirY;
            } else if (direction == 'L') {
                int temp = dirX;
                dirX = -1 * dirY;
                dirY = temp;
            } else {
                int temp = dirX;
                dirX = dirY;
                dirY = -1 * temp;
            }
        }

        return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);
    }

}