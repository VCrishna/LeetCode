class Solution {
    public String largestNumber(int[] nums) {
        // Converting the array of integers to an array of strings
        String[] strNumsArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNumsArray[i] = String.valueOf(nums[i]);
        }

        // Sorting the array of strings in a custom order
        Arrays.sort(strNumsArray, (a, b) -> {
            // Concatenating two strings in different orders and compare
            // The comparison is based on lexicographical order to get the largest number
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        // Checking if the largest number is "0"
        if (strNumsArray[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings to form the largest number
        StringBuilder sb = new StringBuilder();
        for (String s : strNumsArray)
            sb.append(s);
        return sb.toString();
    }
}
