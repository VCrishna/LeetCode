class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        // If the total number of cards is not divisible by the groupSize, it's not possible.
        if (hand.length % groupSize != 0) {
            return false;
        }

        // TreeMap to store the count of each unique card value
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        // Process until TreeMap is empty
        while (map.size() > 0) {
            // Find the smallest value in the TreeMap
            int minValue = map.firstKey();

            // Iterate over groupSize consecutive cards starting from minValue
            for (int card = minValue; card < minValue + groupSize; card++) {
                // Check if the current card doesn't exists in the TreeMap
                if (!map.containsKey(card)) {
                    return false;
                }

                // Update the count for the current card in the TreeMap
                map.put(card, map.get(card) - 1);

                // Remove the card from the TreeMap if the count becomes zero
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }
        return true;
    }
}
