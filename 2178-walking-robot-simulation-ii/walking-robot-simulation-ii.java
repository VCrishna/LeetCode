class Robot {
    int x = 0, y = 0;
    int w, h;
    int dir;
    int[][] mov = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // East(0),North(1),West (2),South (3)
    int peri;

    public Robot(int width, int height) {
        w = width;
        h = height;
        dir = 0;
        peri = 2 * (width + height) - 4;
    }

    public void step(int num) {
        num %= peri;
        if (num == 0) {
            if (x == 0 && y == 0)
                dir = 3;
        }
        while (num > 0) {
            int nx = x + mov[dir][0];
            int ny = y + mov[dir][1];
            if (nx >= w || nx < 0 || ny >= h || ny < 0) {
                dir = (dir + 1) % 4;
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        String[] dirs = { "East", "North", "West", "South" };
        return dirs[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */