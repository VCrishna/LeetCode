class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIndex = 0;
        int greedIndex = 0;

        while(greedIndex < g.length && cookieIndex < s.length) {
            if(g[greedIndex] <= s[cookieIndex]) {
                greedIndex++;
            }
            cookieIndex++;
        }
        return greedIndex;
    }
}
