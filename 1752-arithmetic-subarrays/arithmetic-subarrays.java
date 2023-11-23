class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int n = nums.length;
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int[] newArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(newArray);
            System.out.println(Arrays.toString(newArray));
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
