class Solution {

    public int minOperations(int[] nums, int k) {
        // Create a HashSet to store unique elements that are greater than k
        Set<Integer> st = new HashSet<>();

        // Loop through each number in the input array
        for (int x : nums) {
            // If any number is less than k, the operation is invalid per the logic here
            // So return -1 immediately. (Maybe the problem constraints require all elements to be >= k)
            if (x < k) {
                return -1;
            }
            // If the number is strictly greater than k, we add it to the set
            // to keep track of how many unique numbers greater than k we have
            else if (x > k) {
                st.add(x);
            }
        }

        // The number of operations is the count of unique numbers greater than k
        return st.size();
    }
}
