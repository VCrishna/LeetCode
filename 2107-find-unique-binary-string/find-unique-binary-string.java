class Solution {
    int n;
    public String findDifferentBinaryString(String[] nums) {
        Set<String> numsSet = new HashSet();
        n = nums.length;
        for (String s : nums) {
            numsSet.add(s);
        }

        return backtrack(numsSet, "");
    }
    public String backtrack(Set<String> numsSet, String currentString) {
       
        if (currentString.length() == n) {
            if (!numsSet.contains(currentString)) return currentString;
            return "";
        }

        String addZero = backtrack(numsSet, currentString + "0");
        if (addZero.length() > 0) {
            return addZero;
        }

        return backtrack(numsSet, currentString + "1");
    }
}
