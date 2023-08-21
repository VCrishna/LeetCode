/**

If a String s is a repetitive string, you will find s is a substring of ss.substring(1, ss.length()), where ss = s + s. The reason is, considering the basic case in which s is somestring s' repeated twice, where we have s = s' + s'. Imagine now you hold s to find a match in ss. Only when the cursor moves to the second s' in ss, we will find a match. Meanwhile, you get the pattern length which is the index of s in ss.substring() - 1. So in any repetitive string, you will be able to find a match once proceed the pattern length.
---
s =   'abcabc'
ss = 'abcabcabcabc'

'abcabcabcabc'
  abcabc
	...
'abcabcabcabc'
    abcabc
---


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int idx = (s + s).indexOf(s, 1);
        return  idx < s.length();
    }
}

*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}