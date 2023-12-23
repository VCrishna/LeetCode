class Solution {
    public boolean queryString(String s, int n) {
        for(int i = 1; i <=n; i++) {
            String str = Integer.toBinaryString(i);
            int a = s.indexOf(str);
            if(a == -1) return false;
        }
        return true;
   }
}