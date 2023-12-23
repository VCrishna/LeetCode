class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0"); // initial position
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else if (path.charAt(i) == 'W') {
                x--;
            }
            String direction = x + "," + y;
            if (set.contains(direction)) return true;
            set.add(direction);
        }
        return false;
    }

    public boolean isPathCrossing_BRUTE_FORCE(String path) {
        if (path.length() == 1) return false;
        int direction = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                direction++;
            } else if (path.charAt(i) == 'S') {
                direction--;
            } else if (path.charAt(i) == 'E') {
                direction = direction + 2;
            } else if (path.charAt(i) == 'W') {
                direction = direction - 2;
            }
            if (direction <= 0) return true;
        }

        return false;
    }
}
