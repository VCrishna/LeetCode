class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000, minSpeed = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (timeRequired(dist, middle) <= hour) {
                minSpeed = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return minSpeed;
    }

    double timeRequired(int[] dist, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            // Round off to the next integer, if not the last ride.
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time;
    }
}
