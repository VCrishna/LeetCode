class Solution {
    public String minWindow(String s, String t) {
        if (t == "") {
            return "";
        }
        Map<Character, Integer> tCharFrequencyMap = new HashMap<>();
        Map<Character, Integer> sCharFrequencyMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCharFrequencyMap.put(c, tCharFrequencyMap.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = tCharFrequencyMap.size();
        int[] result = { -1, -1 };
        int resultLength = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (tCharFrequencyMap.containsKey(c)) {
                sCharFrequencyMap.put(c, sCharFrequencyMap.getOrDefault(c, 0) + 1);
                if (sCharFrequencyMap.get(c).equals(tCharFrequencyMap.get(c))) {
                    have++;
                }
            }
            while (have == need) {
                if (right - left + 1 < resultLength) {
                    result[0] = left;
                    result[1] = right;
                    resultLength = right - left + 1;
                }
                // popping from the left of our window
                sCharFrequencyMap.put(s.charAt(left), sCharFrequencyMap.getOrDefault(s.charAt(left), 0) - 1);
                if (tCharFrequencyMap.containsKey(s.charAt(left)) &&
                        sCharFrequencyMap.get(s.charAt(left)) < tCharFrequencyMap.get(s.charAt(left))) {
                    have--;
                }
                left++;
            }
        }
        return resultLength != Integer.MAX_VALUE ? s.substring(result[0], result[1] + 1) : "";
    }
}