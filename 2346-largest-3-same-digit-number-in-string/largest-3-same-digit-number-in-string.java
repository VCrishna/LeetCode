class Solution {
    public String largestGoodInteger(String num) {
        int result = -1; // store best digit found, -1 means none found
        for (int i = 0; i + 2 < num.length(); i++) {
            // Check if current digit and next two are equal
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                // Update max digit if larger
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char) (48 + result)); // ASCII '0' is 48
        }
        return result == -1 ? "" : builder.toString();
    }
    public String largestGoodInteger_CLEAN_APPROACH(String num) {
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