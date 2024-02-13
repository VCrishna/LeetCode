class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right pointers
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Getting the middle index between left and right boundary indexes.
            // hoursSpent stands for the total hour Koko spends.
            int middleIndex = left + (right - left) / 2;
            int hoursSpent = 0;

            for (int pile : piles) {
                // We increase the hourSpent by ceil(pile / middle)
                hoursSpent += Math.ceil((double) pile / middleIndex);
            }

            // Check if middle is a workable speed,
            // and cut the search space by half.
            if (hoursSpent <= h) {
                right = middleIndex;
            } else {
                left = middleIndex + 1;
            }
        }
        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}