class Solution {
    public String largestGoodInteger(String num) {
        String maxGoodInteger = "";

        for (int i = 0; i <= num.length() - 3; i++) {
            String currentSubstr = num.substring(i, i + 3);
            if (isGoodInteger(currentSubstr) && currentSubstr.compareTo(maxGoodInteger) > 0) {
                maxGoodInteger = currentSubstr;
            }
        }

        return maxGoodInteger;
    }

    private boolean isGoodInteger(String str) {
        return str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2);
    }

    public String largestGoodInteger_BRUTE_FORCE(String num) {
        StringBuilder sb = new StringBuilder();
        int currentMax = 0;

        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                currentMax = Math.max(currentMax, Character.getNumericValue(num.charAt(i)));
                sb = new StringBuilder(currentMax + "" + currentMax + "" + currentMax);
            } else {
                continue;
            }
        }

        return sb.toString();
    }
}
