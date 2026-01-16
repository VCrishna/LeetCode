class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // Store all horizontal fence positions
        // Include boundary fences at 1 and m
        List<Integer> horizontal = new ArrayList<>();
        for (int h : hFences) horizontal.add(h);
        horizontal.add(1);
        horizontal.add(m);

        // Store all vertical fence positions
        // Include boundary fences at 1 and n
        List<Integer> vertical = new ArrayList<>();
        for (int v : vFences) vertical.add(v);
        vertical.add(1);
        vertical.add(n);

        // This set stores ALL possible vertical distances
        // formed between any two horizontal fences
        Set<Integer> possibleHeights = new HashSet<>();

        long maxSide = 0;

        // Compute all vertical distances (height candidates)
        for (int i = 0; i < horizontal.size(); i++) {
            for (int j = i + 1; j < horizontal.size(); j++) {
                possibleHeights.add(
                    Math.abs(horizontal.get(j) - horizontal.get(i))
                );
            }
        }

        // Compute all horizontal distances (width candidates)
        // If a width matches any height, it can form a square
        for (int i = 0; i < vertical.size(); i++) {
            for (int j = i + 1; j < vertical.size(); j++) {
                int width = Math.abs(vertical.get(j) - vertical.get(i));
                if (possibleHeights.contains(width)) {
                    maxSide = Math.max(maxSide, width);
                }
            }
        }

        // No square possible
        if (maxSide == 0) {
            return -1;
        }

        // Return square area modulo MOD
        long MOD = 1_000_000_007;
        return (int) ((maxSide * maxSide) % MOD);
    }
}
