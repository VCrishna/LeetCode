class Solution {
    public boolean halvesAreAlike(String s) {
        if(s.length() % 2 != 0) return false;
        int length = s.length();
        int index2 = length / 2;
        int index1 = 0;
        List<Character> vowels = Arrays.asList(
            'a','e','i','o','u',
            'A','E','I','O','U'
        );
        int v1 = 0;
        int v2 = 0;
        while(index2 < length) {
            if(vowels.contains(s.charAt(index2))) {
                v2++;
            }
            index2++;
        }
        while(index1 < length / 2) {
            if(vowels.contains(s.charAt(index1))) {
                v1++;
            }
            index1++;
        }
        return v1 == v2;
    }
}