public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for (String s : strs) encode.append(s.length() + "#" + s);
        // System.out.println(encode.toString());
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (j < s.length()) {
                if (s.charAt(j) == '#') break;
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            decoded.add(s.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }

        return decoded;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));