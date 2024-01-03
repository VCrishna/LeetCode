class Solution {
    public int numberOfBeams(String[] bank) {
        if(bank.length == 0) {
            return 0;
        }
        int numberOfBeams = 0;
        int previosRowLasers = 0;
        for(char c : bank[0].toCharArray()) {
            if(c == '1') previosRowLasers++;
        }
        for(int i = 1; i < bank.length; i++) {
            int currentRowLasers = 0;
            for(char c : bank[i].toCharArray()) {
                if(c == '1') currentRowLasers++;
            }
            if(currentRowLasers > 0) {
                numberOfBeams += currentRowLasers * previosRowLasers;
                previosRowLasers = currentRowLasers;
            }
        }
        return numberOfBeams;
    }
}