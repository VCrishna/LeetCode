class Solution {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int thousands = num / 1000;

        int hundreds = (num % 1000) / 100;

        int tens = (num % 100) / 10;

        int ones = num % 10;

        if (thousands > 0) {
            for (int i = 0; i < thousands; i++) {
                sb.append("M");
            }
        }

        if (hundreds > 0) {
            if (hundreds == 9) {
                sb.append("CM");
            } else if (hundreds == 1)
                sb.append("C");
            else if (hundreds == 4)
                sb.append("CD");
            else {
                if (hundreds == 5)
                    sb.append("D");
                else if (hundreds <= 3) {
                    for (int i = 0; i < hundreds; i++)
                        sb.append("C");
                } else {
                    int rem = hundreds - 5;
                    sb.append("D");
                    for (int i = 0; i < rem; i++) {
                        sb.append("C");
                    }
                }
            }
        }

        if (tens > 0) {
            if (tens == 9) {
                sb.append("XC");
            } else if (tens == 4)
                sb.append("XL");
            else if (tens == 1) {
                sb.append("X");
            } else {
                if (tens <= 3) {
                    for (int i = 0; i < tens; i++) {
                        sb.append("X");
                    }
                } else if (tens == 5) {
                    sb.append("L");
                } else {
                    int rem = tens - 5;
                    sb.append("L");
                    for (int i = 0; i < rem; i++) {
                        sb.append("X");
                    }
                }
            }
        }

        if (ones > 0) {
            if (ones == 9) {
                sb.append("IX");
            } else {
                if (ones <= 5) {
                    if (ones == 4) {
                        sb.append("IV");
                    } else if (ones == 5) {
                        sb.append("V");
                    } else {
                        for (int i = 0; i < ones; i++) {
                            sb.append("I");
                        }
                    }
                } else {
                    int rem = ones - 5;
                    sb.append("V");
                    for (int i = 0; i < rem; i++) {
                        sb.append("I");
                    }
                }
            }
        }

        return sb.toString();

    }
}

// public static String intToRoman(int num) {
// String M[] = {"", "M", "MM", "MMM"};
// String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
// String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
// String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
// return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
// }
// }