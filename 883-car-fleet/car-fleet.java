class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] combined = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }
        Arrays.sort(combined, (a,b) -> a[0] - b[0]);
        Stack<Double> stack = new Stack<>();

        for(int i = combined.length - 1; i >= 0; i--) {
            // time = distance ÷ speed
            double currentTime = (double) (target - combined[i][0]) / combined[i][1];
            if(!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            }
            else
                stack.push(currentTime);
        }

        return stack.size();
    }
}