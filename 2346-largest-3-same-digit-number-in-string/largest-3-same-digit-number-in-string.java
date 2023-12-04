class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder sb = new StringBuilder();
        int currentMax = 0;

        for(int i = 2; i < num.length(); i++) {
            if(num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                currentMax = Math.max(currentMax, Character.getNumericValue(num.charAt(i)));
                // sb = new StringBuilder(num.substring(i-2,i + 1));
                sb = new StringBuilder(currentMax+""+currentMax+""+currentMax);
            }
            else {
                continue;
            }
        }

        return sb.toString();
    }
}