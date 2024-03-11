class Solution {
    public String customSortString(String order, String s) {
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
