class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                if (freq.containsKey(c))
                    freq.put(c, freq.get(c) + 1);
                else
                    freq.put(c, 1);
            }
        }

        Map<Character, Integer> need = new HashMap<>();
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            char c = entry.getKey();
            int fn = entry.getValue();
            int fh = freq.getOrDefault(c, 0);
            int f = fh / fn;
            result = Math.min(result, f);
            if (result == 0)
                return 0;
        }
        return result;
    }
}