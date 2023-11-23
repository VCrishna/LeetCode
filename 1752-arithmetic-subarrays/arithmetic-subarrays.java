class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] newArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            result.add(checkHelper(newArray));
        }

        return result;
    }

    public boolean checkHelper(int[] newArray) {
        Arrays.sort(newArray);
        int diff1 = newArray[1] - newArray[0];
        for (int j = 2; j < newArray.length; j++) {
            int diff2 = newArray[j] - newArray[j - 1];
            if (diff1 != diff2) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays_BRUTE_FORCE(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int n = nums.length;
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int[] newArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(newArray);
            boolean arithSeq = true;
            int diff1 = newArray[1] - newArray[0];
            for (int j = 2; j < newArray.length; j++) {
                int diff2 = newArray[j] - newArray[j - 1];
                if (diff1 != diff2) {
                    arithSeq = false;
                    break;
                }
            }
            result.add(arithSeq);
        }
        return result;
    }
}
