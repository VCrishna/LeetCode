class Solution {

    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIndex = 0;
        int greedIndex = 0;

        while(greedIndex < g.length && cookieIndex < s.length) {
            if(g[greedIndex] <= s[cookieIndex]) {
                result++;
                greedIndex++;
            }
            cookieIndex++;
        }

        
        return result;
    }
}
