class Solution {
    public int minOperations(String s) {
        int minOps = 0;

        for(int i = 0; i < s.length(); i++) {
            // odd index -> it should have 0
            if(i % 2 == 1) {
                if(s.charAt(i) == '0')
                    minOps++;
            }
            // even index -> it should have 1
            else {
                if(s.charAt(i) == '1')
                    minOps++;
            }
        }
        // minimum of minOps or length - minOps
        return Math.min(minOps, s.length() - minOps);        
    }
}

// 0 1 2 3
// 1 0 1 0