class Solution {
    public String largestNumber(int[] nums) {
        String[] strNumsArray = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strNumsArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNumsArray, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        if (strNumsArray[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strNumsArray)
            sb.append(s);
        return sb.toString();
    }
}