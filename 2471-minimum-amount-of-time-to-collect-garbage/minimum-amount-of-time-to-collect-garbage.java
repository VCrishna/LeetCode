class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            result += 3 * travel[i];
        }
        for(int i = 0; i < n; i++) {
            result += garbage[i].length();
        }
        for(int i = n - 1; i > 0; i--) {
            if(!garbage[i].contains("G")) {
                result -= travel[i-1];
            }
            else {
                break;
            }
        }
        for(int i = n - 1; i > 0; i--) {
            if(!garbage[i].contains("P")) {
                result -= travel[i-1];
            }
            else {
                break;
            }
        }
        for(int i = n - 1; i > 0; i--) {
            if(!garbage[i].contains("M")) {
                result -= travel[i-1];
            }
            else {
                break;
            }
        }

        return result;
    }
}