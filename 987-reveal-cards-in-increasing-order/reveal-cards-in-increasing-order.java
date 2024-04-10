class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }
        for (int d : deck) {
            int i = queue.pollFirst();
            result[i] = d;
            if (!queue.isEmpty()) {
                queue.offerLast(queue.pollFirst());
            }
        }

        return result;
    }
}