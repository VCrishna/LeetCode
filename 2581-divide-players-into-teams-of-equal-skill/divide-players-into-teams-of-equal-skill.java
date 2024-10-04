class Solution {
    public long dividePlayers(int[] skill) {
        int skillFreq[] = new int[1001]; // Frequency array to count skills (max value is 1000)

        int total = 0;
        for (int x : skill) {
            skillFreq[x]++; // Count occurrences of each skill
            total += x; // Calculate total sum of all skills
        }

        // If total can't be evenly divided among teams, return -1
        if (total % (skill.length / 2) != 0)
            return -1;

        // Target skill per team
        int perTeamSkill = total / (skill.length / 2);
        long chemistry = 0; // Variable to accumulate the chemistry score

        // Try to find pairs of players
        for (int s : skill) {
            int partnerVal = perTeamSkill - s; // Find the required partner skill

            // If the required partner doesn't exist or is exhausted, return -1
            if (skillFreq[partnerVal] == 0)
                return -1;

            // Add chemistry for the current pair
            chemistry += (long) s * (long) partnerVal;
            skillFreq[partnerVal]--; // Decrement frequency of the partner's skill
        }

        // Return half of the total chemistry because each pair is counted twice
        return chemistry / 2;
    }
}
