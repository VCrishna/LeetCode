class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < points.length; i++) {
            map.clear();
            for(int j = 0; j < points.length; j++) {
                if(i!=j){
                    double distance = calculateDistance(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance,0)+1);
                    // result = Math.max(result, map.get(distance));
                }
            }
            for(int val : map.values()) {
                result += val * (val - 1);
            }
        }
        return result;
    }
    public double calculateDistance(int[] x, int[] y) {
        int res = ((y[0] - x[0])*(y[0] - x[0]) + (y[1] - x[1])*(y[1] - x[1]));
        return Math.sqrt(res);
    }
}