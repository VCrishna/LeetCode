class Solution {

    public Boolean isPalindrome(String s) {
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        if (isPalindrome(s))
            return s;
        int right = s.length() - 1;
        while (right > 0) {
            if (isPalindrome(s.substring(0, right)))
                break;
            right--;
        }
        System.out.print(right);
        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(s.substring(right));

        // reverse StringBuilder input1
        input1.reverse();
        return input1 + s;
    }
}