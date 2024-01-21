class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        // Use a HashSet to store unique powerful integers
        Set<Integer> result = new HashSet<>();

        // Outer loop iterates through powers of x
        for (int i = 0; Math.pow(x, i) <= bound; i++) {
            // Inner loop iterates through powers of y
            for (int j = 0; Math.pow(y, j) <= bound; j++) {
                // Calculate the sum of powers i + j
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));

                // Add the sum to the result set if it's within the bound
                if (sum <= bound) {
                    result.add(sum);
                }

                // Break the inner loop if y is 1 to avoid an infinite loop
                if (y == 1) break;
            }

            // Break the outer loop if x is 1 to avoid an infinite loop
            if (x == 1) break;
        }

        // Convert the HashSet to an ArrayList and return the result
        return new ArrayList<>(result);
    }
}