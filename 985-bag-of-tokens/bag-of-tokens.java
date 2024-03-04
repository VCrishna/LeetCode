class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int result = 0;
        int score = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
            } else if (score > 0 && left < right) {
                power += tokens[right];
                right--;
                score--;
            } else {
                return result;
            }
            result = Math.max(result, score);
        }

        return result;
    }
}