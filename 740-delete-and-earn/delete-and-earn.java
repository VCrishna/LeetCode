class Solution {
    public int deleteAndEarn(int[] nums) {
        // Creating a frequency map to count occurrences of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Using a set to store distinct numbers
        Set<Integer> s = new HashSet<>();

        // Populating the frequency map and the set
        for (int i : nums) {
            s.add(i);
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        // Converting the set to a sorted list for easier traversal
        List<Integer> lst = new ArrayList<>(s);
        Collections.sort(lst);

        int earn1 = 0;
        int earn2 = 0;

        // Iterating through the sorted list of numbers
        for (int i = 0; i < lst.size(); i++) {
            int currentNum = lst.get(i);
            int currentEarn = currentNum * freqMap.get(currentNum);

            if (i > 0 && lst.get(i) == lst.get(i - 1) + 1) {
                // If the current number is consecutive to the previous one
                // We have to decide whether to earn from the current number or not
                // If we earn from the current number, 
                // we can't earn from the previous consecutive number
                // So we choose the maximum of earn1 (points earned excluding the current
                // number) and earn2 (points earned including the current number)
                int temp = earn2;
                earn2 = Math.max(currentEarn + earn1, earn2);
                earn1 = temp;
            } else {
                // If the current number is not consecutive to the previous one
                // We can freely earn from the current number 
                // without affecting previous earnings
                int temp = earn2;
                earn2 = currentEarn + earn2;
                earn1 = temp;
            }
        }

        // Returning the maximum points earned after traversing through all numbers
        return earn2;
    }

    public int deleteAndEarn_EXTRA_SPACE(int[] nums) {
        // Creating a frequency map to count occurrences of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Using a set to store distinct numbers
        Set<Integer> s = new HashSet<>();

        // Populating the frequency map and the set
        for (int i : nums) {
            s.add(i);
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        // Converting the set to a sorted list for easier traversal
        List<Integer> lst = new ArrayList<>(s);
        Collections.sort(lst);

        // Initializing an array to store the maximum points earned at each step
        int[] dp = new int[lst.size()];
        // Base case: the maximum points earned by taking the first number
        dp[0] = lst.get(0) * freqMap.get(lst.get(0));

        // Iterating through the sorted list of numbers
        for (int i = 1; i < lst.size(); i++) {
            int currentNum = lst.get(i);
            int currentEarn = currentNum * freqMap.get(currentNum);

            // If the current number is adjacent to the previous one
            if (lst.get(i - 1) == currentNum - 1) {
                // Skiping current number,
                // and taking the max between not taking it and taking it
                dp[i] = Math.max(dp[i - 1], (i >= 2 ? dp[i - 2] : 0) + currentEarn);
            } else {
                // If not adjacent, taking current number
                dp[i] = dp[i - 1] + currentEarn;
            }
        }

        // Returning the maximum points earned after traversing through all numbers
        return dp[lst.size() - 1];
    }
}
