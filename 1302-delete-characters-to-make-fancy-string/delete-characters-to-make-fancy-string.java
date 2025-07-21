class Solution {
    public String makeFancyString(String s) {
        int freq = 0;
        StringBuilder sb = new StringBuilder();
        char previous = s.charAt(0);
        for (char current : s.toCharArray()) {
            if (current == previous) {
                freq++;
            } else {
                freq = 1;
            }
            if (freq < 3)
                sb.append(current);
            previous = current;
        }
        return sb.toString();
    }
}