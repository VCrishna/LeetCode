class Solution {
    public int fimax(int a, int b) {
        if (a <= b) {
            return b;
        } else {
            return a;
        }
    }

    public int maxActiveSectionsAfterTrade(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int count1 = 0, count2 = 0, i = 0;
        int max = 0;
        int t = 0;

        while (i < n) {
            char c = arr[i];

            if (c == '0') {
                count1++;
                i++;
            } else {
                while (i < n && c == '1') {
                    i++;
                    t++;
                    if (i != n)
                        c = arr[i];
                }

                while (i < n && c == '0') {
                    count2++;
                    i++;
                    if (i != n)
                        c = arr[i];
                }

                if (count1 != 0 && count2 != 0)
                    max = fimax(max, count1 + count2);

                count1 = count2;
                count2 = 0;
            }
        }

        return t + max;
    }
}