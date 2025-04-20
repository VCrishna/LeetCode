class Solution {
    public int numRabbits(int[] answers) {
        // Create a HashMap to store the count of each answer given by the rabbits.
        // The key will be the answer (how many rabbits of the same color),
        // and the value will be the number of rabbits who gave that answer.
        Map<Integer, Integer> answerCounts = new HashMap<>();

        // Iterate through the 'answers' array.
        for (int answer : answers) {
            // For each answer, update its count in the 'answerCounts' map.
            // If the answer is already in the map, increment its count.
            // If it's not, add it to the map with a count of 1.
            answerCounts.put(answer, answerCounts.getOrDefault(answer, 0) + 1);
        }

        // Initialize a variable 'total' to store the minimum total number of rabbits in the forest.
        int totalRabbits = 0;

        // Iterate through each unique answer and its count in the 'answerCounts' map.
        for (Map.Entry<Integer, Integer> entry : answerCounts.entrySet()) {
            // 'sameColorCount' represents the answer given by a group of rabbits (e.g., 1, 2, 0).
            int sameColorCount = entry.getKey();
            // 'count' represents the number of rabbits who gave this specific answer.
            int count = entry.getValue();

            // Logic for calculating the minimum number of rabbits for this answer:
            // If a rabbit answers 'x', it implies there are 'x + 1' rabbits of that color in total (including itself).
            // We need to figure out the minimum number of such color groups to accommodate 'count' rabbits
            // who all gave the answer 'x'.

            // Consider the case where sameColorCount is 0.
            // If a rabbit answers 0, it claims to be the only one of its color among those who answered.
            // To minimize, we assume it is the only one of its color in the forest for this group.
            // So, each rabbit answering 0 contributes 1 to the total.
            if (sameColorCount == 0) {
                totalRabbits += count;
            } else {
                // If the answer is not 0, each color group has 'sameColorCount + 1' rabbits.
                // We need to determine how many such groups are needed to account for 'count' rabbits.

                // Example: If sameColorCount is 1, each group has 1 + 1 = 2 rabbits.
                // If 'count' is 3 (three rabbits answered 1), they cannot all be from the same group of 2.
                // We would need ceil(3 / 2) = 2 groups of size 2, totaling 2 * 2 = 4 rabbits.

                // Example: If sameColorCount is 2, each group has 2 + 1 = 3 rabbits.
                // If 'count' is 7 (seven rabbits answered 2), we would need ceil(7 / 3) = 3 groups of size 3,
                // totaling 3 * 3 = 9 rabbits.

                // The number of groups needed is the ceiling of 'count' divided by the size of each group ('sameColorCount + 1').
                int numGroups = (int) Math.ceil((double) count / (sameColorCount + 1));

                // The total number of rabbits for this specific answer is the number of groups multiplied by the size of each group.
                totalRabbits += numGroups * (sameColorCount + 1);
            }
        }

        // Return the minimum total number of rabbits in the forest.
        return totalRabbits;
    }
}