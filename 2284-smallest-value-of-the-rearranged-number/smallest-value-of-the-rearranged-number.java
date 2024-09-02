class Solution {
    public long smallestNumber(long num) {

        if (num == 0)
            return 0;
        // setting neg variable to true if the given value is negative
        boolean neg = num < 0;

        // If given num is negative then we are converting it to positve
        num = num < 0 ? num * -1 : num;

        // Creating a character array of the given num
        char[] c = String.valueOf(num).toCharArray();
        Arrays.sort(c);
        String s;
        for (char x : c)
            System.out.println(x);

        if (!neg) {
            int non = 0;
            // if not negative we need to find out
            // the first non-leading zero then swap with first zero
            for (; non < c.length; non++) {
                if (c[non] != '0') {
                    break;
                }
            }
            char temp = c[non];
            c[non] = c[0];
            c[0] = temp;
            s = new String(c);
        } else {
            s = new String(c);
            StringBuilder sb = new StringBuilder(s);
            s = "-".concat(sb.reverse().toString());
        }

        return Long.valueOf(s);

    }
}