public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for (String s : strs)
            encode.append(s.length() + "#" + s);
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (j < s.length()) {
                if (s.charAt(j) == '#') {
                    break;
                }
                j++;
            }
            int size = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + 1 + size));
            i = j + 1 + size;
        }

        return result;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
