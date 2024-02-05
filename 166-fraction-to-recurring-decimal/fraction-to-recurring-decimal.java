class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        // Handle the case when the numerator is 0
        if (numerator == 0) {
            return "0";
        }

        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Determine the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Take absolute values to simplify calculations
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Calculate the integer part of the result
        result.append(num / den);

        // Calculate the remainder after integer division
        long remainder = num % den;

        // If there is no remainder, return the result
        if (remainder == 0) {
            return result.toString();
        }

        // Add the decimal point
        result.append(".");

        // Use a HashMap to store remainders and their positions
        Map<Long, Integer> seenRemainders = new HashMap<>();

        // Process the fractional part
        while (remainder != 0) {
            // If the remainder repeats, handle repeating decimals
            if (seenRemainders.containsKey(remainder)) {
                int nonRepeatingIndex = seenRemainders.get(remainder);
                String nonRepeating = result.substring(0, nonRepeatingIndex);
                String repeating = result.substring(nonRepeatingIndex);
                return nonRepeating + "(" + repeating + ")";
            }

            // Store the current remainder and its position
            seenRemainders.put(remainder, result.length());

            // Multiply the remainder by 10 for the next division
            remainder *= 10;

            // Append the next digit to the result
            result.append(remainder / den);

            // Update the remainder for the next iteration
            remainder %= den;
        }

        // If the loop exits without repeating, return the result
        return result.toString();
    }
}