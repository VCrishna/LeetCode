class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int length = nums.length;
        Map<Integer, Integer>[] map = new Map[length];

        for(int i = 0; i < length; i++) {
            map[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                long diff = (long)(nums[j]) - nums[i];
                if(diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) 
                    continue;
                int dif = (int)diff;
                int n2 = map[i].getOrDefault(dif, 0);
                int n1 = map[j].getOrDefault(dif, 0);
                result += n1;
                int freq = n1 + n2 + 1;
                map[i].put(dif, freq);
            }
        }

        return result;
    }
}