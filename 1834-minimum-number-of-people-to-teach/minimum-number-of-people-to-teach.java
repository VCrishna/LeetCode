class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        // Step 1: Identify which people cannot currently communicate
        Set<Integer> need = new HashSet<>();
        for(int[] p : friendships) {
            int u = p[0] - 1, v = p[1] - 1; // convert to 0-based index
            boolean ok = false;

            // Check if u and v share a common language
            for(int x : languages[u]) {
                for(int y : languages[v]) {
                    if(x == y) { ok = true; break; }
                }
                if(ok) break;
            }

            // If they cannot communicate, add both to the set of people needing teaching
            if(!ok) { 
                need.add(u); 
                need.add(v); 
            }
        }

        // Step 2: Try teaching each language (1..n) to see which minimizes the number of new teachings
        int ans = languages.length + 1; // initialize with a large number
        for(int i = 1; i <= n; i++) {
            int cans = 0; // number of people who need to learn language i
            for(int v : need) {
                boolean found = false;
                for(int c : languages[v]) {
                    if(c == i) { found = true; break; } // already knows this language
                }
                if(!found) cans++; // need to teach language i
            }

            // Update the minimum across all languages
            ans = Math.min(ans, cans);
        }

        return ans;
    }
}
