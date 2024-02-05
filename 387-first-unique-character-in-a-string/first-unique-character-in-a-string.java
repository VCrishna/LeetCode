class Solution {
    public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int result  = Integer.MAX_VALUE;
        // Iterating from a to z which is 26 which makes it constant
        for (char c = 'a'; c <= 'z'; c++) {
            // indexOf will return first index of alphabet 
            // lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                result  = Math.min(result , index);
            }
        }
        // If result  remain's Integer.MAX_VALUE then their is no unique character
        return result  == Integer.MAX_VALUE ? -1 : result;
    }

    public int firstUniqChar_INT_ARRAY(String s) {
        int countArray[] = new int[26];
        for (char c : s.toCharArray()) {
            countArray[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (countArray[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_MAP(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}