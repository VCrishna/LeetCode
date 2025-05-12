class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int freq[] = new int[10];
        for (int e : digits) {
            freq[e]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 100; i <= 999; i++) {
            if (i % 2 == 0 && isValid(freq, i)) {
                list.add(i);
            }
        }
        int res[] = new int[list.size()];
        int i = 0;
        for (int e : list) {
            res[i++] = e;
        }

        return res;
    }

    public boolean isValid(int freq[], int i) {
        int temp[] = freq.clone();
        while (i != 0) {
            int lastDigit = i % 10;
            if (temp[lastDigit] > 0) {
                temp[lastDigit]--;
            } else
                return false;
            i = i / 10;
        }
        return true;
    }
}