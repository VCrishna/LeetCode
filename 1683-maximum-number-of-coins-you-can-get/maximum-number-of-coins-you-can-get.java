class Solution {
    public int maxCoins(int[] piles) {
        int result = 0;

        Arrays.sort(piles);

        for(int i = piles.length - 2; i >= piles.length / 3; i = i - 2) {
            result += piles[i];
        }

        return result;
    }
}