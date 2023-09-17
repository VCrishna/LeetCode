class Solution {
    public String countAndSay(int n) {
        String current = "1";
        for (int i = 0; i < n-1; i++) {
            StringBuilder sb = new StringBuilder();
            char ch = current.charAt(0);
            int count = 1;
            for (int j = 1; j < current.length(); j++) {
                if (ch != current.charAt(j)) {
                    sb.append(count);
                    sb.append(ch);
                    count = 0;
                    ch = current.charAt(j);
                }
                count++;
            }
            sb.append(count);
            sb.append(ch);
            current = sb.toString();
        }
        return current;
    }
}
