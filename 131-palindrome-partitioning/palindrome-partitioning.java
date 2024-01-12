class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        // dfs - s, result, partition, index
        dfs(s, result, partition, 0);
        return result;
    }

    public void dfs(
        String s,
        List<List<String>> result,
        List<String> partition,
        int index
    ) {
        if(index >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                partition.add(s.substring(index, i + 1));
                dfs(s, result, partition, i + 1);
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