class Solution {
    public int findClosest(int x, int y, int z) {
        int xDiff = Math.abs(z - x);
        int yDiff = Math.abs(z - y);
        if (xDiff == yDiff)
            return 0;
        return xDiff < yDiff ? 1 : 2;
    }
}