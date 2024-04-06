class Solution {
    public String minRemoveToMakeValid(String s) {
        List<Character> lst = new ArrayList<>();
        List<Character> filtered = new ArrayList<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lst.add(c);
                count++;
            } else if (c == ')' && count > 0) {
                lst.add(c);
                count--;
            } else if (c != ')') {
                lst.add(c);
            }
        }
        for (int i = lst.size() - 1; i >= 0; i--) {
            if (lst.get(i) == '(' && count > 0) {
                count--;
            } else {
                filtered.add(lst.get(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c : filtered) result.append(c);
        return result.reverse().toString();
    }
}