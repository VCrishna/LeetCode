class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set s = new HashSet<>();
        for (int i : nums) {
            s.add(i);
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> lst = new ArrayList<>(s);
        Collections.sort(lst);

        int[] dp = new int[lst.size()];
        dp[0] = lst.get(0) * freqMap.get(lst.get(0));

        for (int i = 1; i < lst.size(); i++) {
            int currentNum = lst.get(i);
            int currentSum = currentNum * freqMap.get(currentNum);
            // If the current number is adjacent to the previous one
            if (lst.get(i - 1) == currentNum - 1) {
                // Skipping current number, 
                // and take the max between not taking it and taking it
                dp[i] = Math.max(dp[i - 1], (i >= 2 ? dp[i - 2] : 0) + currentSum);
            } else {
                // If not adjacent, taking current number
                dp[i] = dp[i - 1] + currentSum;
            }
        }

        return dp[lst.size() - 1];
    }
}