class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
        // for(int i = 1; i <= n; i++) {
        //     String binaryString = Integer.toBinaryString(i);
        //     int index = s.indexOf(binaryString);
        //     if(index == -1)
        //         return false;
        // }
        // return true;
    }
}
