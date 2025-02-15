class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canSplit(Integer.toString(square), 0, i)) {
                result += square;
            }
        }
        return result;
    }

    private boolean canSplit(String str, int index, int target) {
        if (index == str.length()) {
            return target == 0;
        }

        int num = 0;
        for (int i = index; i < str.length(); i++) {
            num = num * 10 + (str.charAt(i) - '0');
            if (num > target)
                break; // Prune search space if num exceeds target
            if (canSplit(str, i + 1, target - num)) {
                return true;
            }
        }
        return false;
    }
}
