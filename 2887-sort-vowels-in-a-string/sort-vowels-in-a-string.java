class Solution {
    public String sortVowels(String s) {
        // Step 1: Define what vowels are (both lowercase and uppercase)
        List<Character> vowels = Arrays.asList('a','A','e','E','i','I','o','O','u','U');

        // Step 2: Extract all vowels from the string (store ASCII values for sorting)
        List<Integer> vowelsInS = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(vowels.contains(c)) {
                vowelsInS.add((int)c); // cast char → int so sorting uses ASCII order
            }
        }

        // Step 3: Sort all vowels in ascending ASCII order
        // (Uppercase letters come before lowercase letters, e.g. 'A' < 'a')
        Collections.sort(vowelsInS);

        // Step 4: Rebuild the string
        StringBuilder sb = new StringBuilder();
        int vowelIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                // Replace vowel with the next one from the sorted list
                int c = vowelsInS.get(vowelIndex++);
                sb.append((char)c);
            } else {
                // Non-vowels remain unchanged
                sb.append(s.charAt(i));
            }
        }

        // Step 5: Return the final transformed string
        return sb.toString();
    }
}
