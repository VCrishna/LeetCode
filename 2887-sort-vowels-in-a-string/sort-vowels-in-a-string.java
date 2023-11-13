class Solution {
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
                sb.append((char)c+"");
                
            } else {
                sb.append(s.charAt(i)+"");
            }
        }
        return sb.toString();
    }
}
