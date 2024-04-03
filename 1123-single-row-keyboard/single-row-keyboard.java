class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] freqArray = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            freqArray[keyboard.charAt(i) - 'a'] = i;
        }
        int result = 0;
        int previous = 0;

        for (char c : word.toCharArray()) {
            result += Math.abs(previous - freqArray[c - 'a']);
            previous = freqArray[c - 'a'];
        }

        return result;
    }

    public int calculateTime_MAP(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int result = 0;
        int previous = 0;

        for (char c : word.toCharArray()) {
            result += Math.abs(previous - map.get(c));
            previous = map.get(c);
        }

        return result;
    }
}