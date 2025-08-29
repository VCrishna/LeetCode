class Solution {
    public long flowerGame(int n, int m) {
        // Each flower has petals labeled 1..n or 1..m.
        // Alice wins if (Alice petals + Bob petals) is odd.
        // Odd sum happens when one is odd, the other even.
        // Exactly half of all possible (n * m) pairs are odd sums.
        // So answer = n * m / 2.
        
        return 1L * n * m / 2;  // 1L ensures multiplication is in long to avoid overflow
    }
}
