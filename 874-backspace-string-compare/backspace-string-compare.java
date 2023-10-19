class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '#' && !s1.isEmpty()) {
                s1.pop();
            }
            else if(c == '#')
                continue;
            else
                s1.push(c);
        }
        for(char c : t.toCharArray()) {
            if(c == '#' && !s2.isEmpty()) {
                s2.pop();
            }
            else if(c == '#')
                continue;
            else
                s2.push(c);
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char c : s1) {
            sb1.append(c);
        }
        for(char c : s2) {
            sb2.append(c);
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }
}