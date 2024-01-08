class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        while(map.size() > 0) {
            int minHand = map.firstKey();

            for(int i = minHand; i < minHand + groupSize; i++){
                if(!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.getOrDefault(i, 0) - 1);
                if(map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }

        return true;
    }
}