class Solution {
    public String smallestNumber(String pattern) {
        int size = pattern.length();

        // Initializing an array to store the result
        int[] ans = new int[size + 1];

        // Initializing the array with consecutive numbers starting from 1
        for (int i = 0; i < size + 1; i++) {
            ans[i] = i + 1;
        }

        // Iterating through the pattern to generate the smallest number
        for (int i = 0; i < size; i++) {
            // Identifying the segment of consecutive 'D's in the pattern
            int temp = i;
            while (temp < size && pattern.charAt(temp) == 'D') {
                temp++;
            }

            // Reversing the segment in the result array
            reverse(ans, i, temp);

            // Updating the index to skip the reversed segment
            if (temp != i)
                i = temp - 1;
        }
        // System.out.println(Arrays.toString(ans));
        // Converting the result array to a string and remove unnecessary characters
        return Arrays.toString(ans).replaceAll("\\[|\\]|,|\\s", "");
    }

    // Function to reverse a segment in the array
    public void reverse(int[] ans, int left, int right) {
        while (left < right) {
            int temp = ans[left];
            ans[left] = ans[right];
            ans[right] = temp;
            left++;
            right--;
        }
    }
}
