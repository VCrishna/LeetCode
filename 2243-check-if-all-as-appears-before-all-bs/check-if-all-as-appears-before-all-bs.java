class Solution {
    public boolean checkString(String s) {
        if (s.length() <= 1)
            return true;
        List<Integer> indA = new ArrayList<>();
        List<Integer> indB = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                indA.add(i);
            } else {
                indB.add(i);
            }
        }
        if (indA.size() == 0 || indB.size() == 0)
            return true;
        for (Integer j : indA) {
            if (j > indB.get(0)) {
                return false;
            }
        }
        return true;
    }
}