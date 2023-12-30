class Solution {

    public boolean makeEqual(String[] words) {
        if(words.length == 1) return true;
        int[] count = new int[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
        }
        System.out.println(Arrays.toString(count));
        for (int i : count) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
// ["abc","aabc","bc"]
// a = 3, b = 3, c = 3
