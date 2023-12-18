public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length() + "#" + s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> words = new ArrayList<>();
        if(s.length() == 0 || s == null) return words;
        int i = 0;
        while(i < s.length()) {
            int j = i;
            // finding delimitter
            while(j < s.length()) {
                if(s.charAt(j) == '#') {
                    break;
                }
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            words.add(s.substring(j+1, j+1+length));
            i = j + 1 + length;
        }

        return words;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
