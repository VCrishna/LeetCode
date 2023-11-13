class Solution {
    // public String sortVowels(String s) {
    //     List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    //     // Filter and collect vowels in a List
    //     List<Character> vowelList = s.chars()
    //             .mapToObj(c -> (char) c)
    //             .filter(vowels::contains)
    //             .sorted()
    //             .collect(Collectors.toList());

    //     // Build the result string
    //     StringBuilder sb = new StringBuilder();
    //     int vowelIndex = 0;
    //     for (char c : s.toCharArray()) {
    //         if (vowels.contains(c)) {
    //             sb.append(vowelList.get(vowelIndex++));
    //         } else {
    //             sb.append(c);
    //         }
    //     }

    //     return sb.toString();
    // }
    public String sortVowels(String s) {
        List<Integer> pq = new ArrayList<>();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                pq.add((int) c);
            }
        }
        Collections.sort(pq);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                int c = pq.get(index++);
                sb.append((char)c);
                
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
