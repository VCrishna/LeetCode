class Solution {

    public long minimumCost(int[] nums, int k, int dist) {

        int n = nums.length;

        /*
         result = minimum sum we can achieve
         (we will add nums[0] at the end because index 0 is always included)
        */
        long result = Long.MAX_VALUE;

        /*
         windowSum = sum of the chosen (k-1) elements inside the sliding window
        */
        long windowSum = 0L;

        /*
         TreeSet "using":
         - stores indices of elements currently selected
         - ordered by nums[index] (value), then index (tie-breaker)
         - always keeps the smallest (k-1) values
        */
        java.util.TreeSet<Integer> using = new java.util.TreeSet<>(
            (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        /*
         TreeSet "waiting":
         - stores indices inside the window but NOT selected
         - same ordering rule
        */
        java.util.TreeSet<Integer> waiting = new java.util.TreeSet<>(
            (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        /*
         STEP 1: Initialize the first window
         Window range: [1 ... dist + 1]
         We temporarily put everything into "using"
        */
        for (int i = 1; i <= dist + 1; i++) {
            using.add(i);
            windowSum += nums[i];
        }

        /*
         Keep only the smallest (k-1) elements in "using"
         Move the rest to "waiting"
        */
        while (using.size() > k - 1) {
            int idx = using.pollLast(); // remove largest
            windowSum -= nums[idx];
            waiting.add(idx);
        }

        /*
         First valid answer
        */
        result = Math.min(result, windowSum);

        /*
         STEP 2: Slide the window
         At each step:
         - one element leaves the window
         - one element enters the window
         - rebalance "using" and "waiting" to keep smallest (k-1)
        */
        for (int i = 1; i + dist + 1 < n; i++) {

            /*
             Add new element entering the window
            */
            waiting.add(i + dist + 1);

            /*
             CASE 1: outgoing element was selected (in "using")
             → remove it and replace with the smallest from waiting
            */
            if (using.contains(i)) {
                using.remove(i);
                windowSum -= nums[i];

                int idx = waiting.pollFirst(); // smallest available
                using.add(idx);
                windowSum += nums[idx];

            }
            /*
             CASE 2: outgoing element was not selected (in "waiting")
             → may need rebalancing
            */
            else {
                waiting.remove(i);

                /*
                 Compare:
                 - smallest element in waiting
                 - largest element in using
                 If waiting has a smaller value, swap them
                */
                int wMin = waiting.first();
                int uMax = using.last();

                if (nums[wMin] < nums[uMax]) {

                    // move uMax out of using
                    using.remove(uMax);
                    waiting.add(uMax);
                    windowSum -= nums[uMax];

                    // bring wMin into using
                    waiting.remove(wMin);
                    using.add(wMin);
                    windowSum += nums[wMin];
                }
            }

            /*
             Update minimum answer
            */
            result = Math.min(result, windowSum);
        }

        /*
         nums[0] is always included in the final cost
        */
        return result + nums[0];
    }
}
