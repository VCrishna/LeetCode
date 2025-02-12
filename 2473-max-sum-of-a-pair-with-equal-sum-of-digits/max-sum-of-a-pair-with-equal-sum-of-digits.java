class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for(int num:nums) {
            int totalSum = getNumberTotal(num);
            if(!map.containsKey(totalSum)){
                map.put(totalSum, num);
            }
            else {
                result = Math.max(result, map.get(totalSum)+num);
                map.put(totalSum, Math.max(map.get(totalSum),num));
            }
        }
        return result;
    }
    public int getNumberTotal(int num) {
        int result = 0;
        while(num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}