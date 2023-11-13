class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = Arrays.asList('a','A','e','E','i','I','o','O','u','U');
        List<Integer> vowelsInS = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(vowels.contains(c)) {
                vowelsInS.add((int)c);
            }
        }
        Collections.sort(vowelsInS);
        StringBuilder sb = new StringBuilder();
        int vowelIndex = 0;;
        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                int c = vowelsInS.get(vowelIndex++);
                sb.append((char)c);
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}