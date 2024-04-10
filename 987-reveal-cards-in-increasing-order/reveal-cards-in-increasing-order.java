class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Sorting the deck in increasing order
        Arrays.sort(deck);

        // Initializing an array to store the result
        int[] result = new int[deck.length];

        // Creating a deque to simulate the revealed order
        Deque<Integer> queue = new ArrayDeque<>();

        // Initializing the deque with indices of the deck
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }

        // Revealing the cards in the increasing order and update the result array
        for (int d : deck) {
            // Get the index of the card to be revealed
            int i = queue.pollFirst(); // Simulates revealing the top card from the deck
            result[i] = d; // Assigning the revealed card value to the result array at the index

            // If there are more cards remaining in the deck,
            // moving the revealed card to the bottom of the deck
            if (!queue.isEmpty()) {
                queue.offerLast(queue.pollFirst());
            }
        }

        // Returning the result array containing the revealed cards in increasing order
        return result;
    }
}
