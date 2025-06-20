class Solution {
    public int maxDistance(String s, int k) {
        // Counters for each direction
        int N = 0, S = 0, W = 0, E = 0;

        int res = 0; // Store the maximum distance at any point

        // Traverse through the string and simulate movement
        for(char ch: s.toCharArray()){
            switch(ch){
                case 'N': N++; break;
                case 'S': S++; break;
                case 'W': W++; break;
                case 'E': E++; break;
            }

            // After every move, calculate the best possible distance with up to k changes
            res = Math.max(res, getDist(N, S, W, E, k));
        }
        return res;
    }
    
    // Calculates max Manhattan Distance with up to k changes
    int getDist(int N, int S, int W, int E, int k){
        // Always treat N >= S and W >= E to simplify logic
        if(S > N){
            int temp = S; S = N; N = temp;
        }
        if(E > W){
            int temp = E; E = W; W = temp;
        }

        // Base distance without changes
        int dist = (N - S) + (W - E);

        // Use changes to cancel opposing directions
        if(k >= S){
            dist += 2 * S; // Flip all S to N
            k -= S;

            // Use remaining changes to flip some E to W
            dist += 2 * Math.min(k, E);
        }else{
            // Not enough k to flip all S to N — just flip k of them
            dist += 2 * k;
        }

        return dist;
    }
}
