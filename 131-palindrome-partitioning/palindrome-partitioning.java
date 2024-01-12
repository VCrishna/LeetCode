class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        // dfs - s, result, partition, index
        dfs(s, result, partition, 0);
        return result;
    }

    // Depth-First Search method
    public void dfs(
            String s,
            List<List<String>> result,
            List<String> partition,
            int index) {
        // If the current index exceeds the string length, 
        // add the current partition to the result
        if (index >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        // Iterating through the string starting from the current index
        for (int i = index; i < s.length(); i++) {
            // Checking if the substring from the current index to i is a palindrome
            if (isPalindrome(s, index, i)) {
                // Adding the palindrome substring to the partition list
                partition.add(s.substring(index, i + 1));
                // Recursively calling dfs with the next index
                dfs(s, result, partition, i + 1);
                // Backtrack: Removing the last added substring to explore other possibilities
                partition.remove(partition.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}