class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < s.length(); i += k) {
            if (i + k < s.length()) {
                StringBuilder ss = new StringBuilder(s.substring(i, i + k));
                while (ss.length() < k) {
                    ss.append(fill);
                }
                lst.add(ss.toString());
            } else {
                StringBuilder ss = new StringBuilder(s.substring(i));
                while (ss.length() < k) {
                    ss.append(fill);
                }
                lst.add(ss.toString());
            }
        }
        return lst.toArray(String[]::new);
    }
}