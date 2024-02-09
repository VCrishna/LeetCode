class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();

        for(int num : nums) {
            dp.add(new  ArrayList<>());
        }

        for(int i = 0; i < nums.length; i++) {
            List<Integer> current = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                if(
                    nums[i] % nums[j] == 0 &&
                    current.size() < dp.get(j).size()
                    )
                    {
                        current = dp.get(j);
                    }
            }
            dp.get(i).addAll(current);
            dp.get(i).add(nums[i]);
        }

        for(int i = 0; i < dp.size(); i++) {
            if(result.size() < dp.get(i).size()){
                result = dp.get(i);
            }
        }

        return result;
    }
}