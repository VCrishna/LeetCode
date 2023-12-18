public class Codec {
    Map<Integer, String> encode;
    String base = "http://tinyurl.com/";
    int i;
    public Codec() {
        i = 1;
        encode = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        encode.put(i, longUrl);
        return base + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace(base,""));
        return encode.get(key);
    }
    // Map<String, String> encode;
    // Map<String, String> decode;
    // String base = "http://tinyurl.com/";
    // public Codec() {
    //     encode = new HashMap<>();
    //     decode = new HashMap<>();
    // }
    // // Encodes a URL to a shortened URL.
    // public String encode(String longUrl) {
    //     if(!encode.containsKey(longUrl)) {
    //         String shortUrl = base + encode.size();
    //         encode.put(longUrl, shortUrl);
    //         decode.put(shortUrl, longUrl);
    //     }
    //     return encode.get(longUrl);
    // }

    // // Decodes a shortened URL to its original URL.
    // public String decode(String shortUrl) {
    //     return decode.get(shortUrl);
    // }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
