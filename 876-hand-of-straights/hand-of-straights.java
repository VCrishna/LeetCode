class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        map.forEach((x, y) -> System.out.println(x + " " + y));
        for (int num : hand) {
            if (map.getOrDefault(num, 0) > 0) {
                // Check for a consecutive sequence of length groupSize
                for (int i = 0; i < groupSize; i++) {
                    if (map.getOrDefault(num + i, 0) == 0) {
                        return false;
                    }
                    map.put(num + i, map.get(num + i) - 1);
                }
            }
        }
        return true;
    }
}
// hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// hand = [1,2,2,3,3,4,6,7,8]
