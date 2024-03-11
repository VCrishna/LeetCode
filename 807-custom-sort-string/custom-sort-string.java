class Solution {
    public String customSortString(String order, String s) {
        // StringBuilder to store the sorted string
        StringBuilder result = new StringBuilder();
        // Map to store the frequency of each character in the input string 's'
        Map<Character, Integer> freqMap = new HashMap<>();

        // Counting the frequency of each character in the input string 's'
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Iterating through each character in the 'order' string
        for (int i = 0; i < order.length(); i++) {
            char currentChar = order.charAt(i);
            // Checking if the current character exists in the frequency map
            if (freqMap.containsKey(currentChar)) {
                // While there are occurrences of the current character in the 'order' 
                // string ppend them to the result string, and decrement the 
                // count of occurrences in the frequency map
                while (freqMap.get(currentChar) > 0) {
                    result.append(currentChar);
                    freqMap.put(currentChar, freqMap.get(currentChar) - 1);
                }
            }
        }

        // Appending remaining characters (not found in the 'order' string) 
        // to the result string
        for (char c : freqMap.keySet()) {
            int count = freqMap.get(c);
            while (count > 0) {
                result.append(c);
                count--;
            }
        }

        // Returning the sorted string
        return result.toString();
    }

    public String customSortString_MY_METHOD(String order, String s) {
        // StringBuilder to store the sorted string
        StringBuilder sb = new StringBuilder();

        // List to store characters in 's' that match the order specified
        List<String> sortList = new ArrayList<>();

        // Iterating through each character in 's'
        for (int i = 0; i < s.length(); i++) {
            // If the 'order' string contains the current character in 's',
            // adding it to the 'sortList' list
            if (order.contains(s.charAt(i) + "")) {
                sortList.add(s.charAt(i) + "");
            } else {
                // Otherwise, appending it directly to 'sb' as it's not in the specified order
                sb.append(s.charAt(i) + "");
            }
        }

        // Iterating through each character in the 'order' string
        for (char ch : order.toCharArray()) {
            // Looping through the 'sortList' list to find the characters in the 'order'
            // string
            for (int i = 0; i < sortList.size(); i++) {
                // If the character from 'sortList' matches the current character from 'order'
                if (sortList.get(i).equals(ch + "")) {
                    // Appending it to the 'sb' StringBuilder
                    sb.append(sortList.get(i));
                    // Removing it from 'sortList' to avoid duplicates
                    sortList.remove(i);
                    // Reseting the loop counter to start from the beginning of 'sortList'
                    i = -1;
                }
            }
        }
        // Returning the sorted string
        return sb.toString();
    }
}
