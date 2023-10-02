class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceCount = 0, bobCount = 0;
        int consecutiveA = 0, consecutiveB = 0;

        for(char ch : colors.toCharArray()) {
            if(ch == 'A') {
                consecutiveA++;
                consecutiveB = 0;
                if(consecutiveA >= 3) aliceCount++;
            }
            else {
                consecutiveB++;
                consecutiveA = 0;
                if(consecutiveB >= 3) bobCount++;
            }
        }

        return aliceCount > bobCount;
    }
}