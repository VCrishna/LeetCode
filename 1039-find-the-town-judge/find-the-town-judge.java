class Solution {
    // Method to find the judge using indegree and outdegree approach
    public int findJudge(int N, int[][] trust) {

        // If the number of relationships in the trust array is less than N-1,
        // it's impossible to find a judge
        if (trust.length < N - 1) {
            return -1;
        }

        // Arrays to keep track of indegrees and outdegrees of each person
        // indegrees[i] stores the number of trusts received by person i
        int[] indegrees = new int[N + 1];
        // outdegrees[i] stores the number of trusts made by person i
        int[] outdegrees = new int[N + 1];

        // Calculating indegrees and outdegrees based on the trust relationships
        for (int[] relation : trust) {
            outdegrees[relation[0]]++; // Increment outdegree for the person who trusts
            indegrees[relation[1]]++; // Increment indegree for the person who is trusted
        }

        // Checking for a person who has N-1 indegrees (i.e., is trusted by everyone)
        // and 0 outdegrees (i.e., doesn't trust anyone)
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i; // Found the judge
            }
        }
        return -1; // No judge found
    }

    // Method to find the judge using array of trust scores approach
    public int findJudge_ARRAY(int N, int[][] trust) {

        // If the number of relationships in the trust array is less than N-1, 
        // it's impossible to find a judge
        if (trust.length < N - 1) {
            return -1;
        }

        // Array to keep track of trust scores of each person
        int[] trustScores = new int[N + 1]; // trustScores[i] stores the net trust score of person i

        // Calculating trust scores based on the trust relationships
        for (int[] relation : trust) {
            trustScores[relation[0]]--; // Decrement trust score for the person who trusts
            trustScores[relation[1]]++; // Increment trust score for the person who is trusted
        }

        // Checking for a person with a trust score of N-1 (i.e., trusted by everyone)
        for (int i = 1; i <= N; i++) {
            if (trustScores[i] == N - 1) {
                return i; // Found the judge
            }
        }
        return -1; // No judge found
    }
}