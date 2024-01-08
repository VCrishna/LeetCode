class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        while (map.size() > 0) {
            int minValue = map.firstKey();
            for (int card = minValue; card < minValue + groupSize; card++) {
                if (!map.containsKey(card)) return false;
                map.put(card, map.get(card) - 1);
                if (map.get(card) == 0) map.remove(card);
            }
        }
        return true;
    }
}
// hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// hand = [1,2,2,3,3,4,6,7,8]
