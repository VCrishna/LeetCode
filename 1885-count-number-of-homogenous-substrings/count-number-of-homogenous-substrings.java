class Solution {
    public int countHomogenous(String s) {
        int count = 0;
        int currentStreak = 0;
        int MOD = (int) 1e9 + 7;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 || s.charAt(i) == s.charAt(i-1))
                currentStreak++;
            else
                currentStreak = 1;
            count = (count + currentStreak) % MOD;
        }

        return count;
    }
}