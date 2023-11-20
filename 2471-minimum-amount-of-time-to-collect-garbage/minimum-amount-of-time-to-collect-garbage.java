class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int result = 0;
        // Total time taken to travel by 3 trucks to all the houses (considering all houses have all types of garbage )
        for (int i = 0; i < n - 1; i++) {
            result += 3 * travel[i];
        }
        // Total time taken to pick up all garbage from all houses (each pickup takes 1 min)
        for (String s : garbage) {
            result += s.length();
        }
        // finding the last house which contains G
        // and subtracting any extra time we calculated in line 7
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("G")) {
                result -= travel[i - 1];
            } else {
                break;
            }
        }
        // finding the last house which contains P
        // and subtracting any extra time we calculated in line 7
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("P")) {
                result -= travel[i - 1];
            } else {
                break;
            }
        }
        // finding the last house which contains M
        // and subtracting any extra time we calculated in line 7
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("M")) {
                result -= travel[i - 1];
            } else {
                break;
            }
        }
        return result;
    }
}
