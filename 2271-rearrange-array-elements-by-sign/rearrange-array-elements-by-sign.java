class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList();
        List<Integer> negative = new ArrayList();

        for(int i : nums) {
            if(i < 0) {
                negative.add(i);
            }
            else {
                positive.add(i);
            }
        }
        int[] result = new int[nums.length];
        int even = 0;
        int odd = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                result[i] = positive.get(even++);
            }
            else {
                result[i] = negative.get(odd++);
            }
        }

        return result;

    }
}