class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> st = new HashSet<>();
        int left = 0,right = 0;
        while(right < s.length()){
            if(!st.contains(s.charAt(right))){
                st.add(s.charAt(right));
                max=Math.max(max,st.size());
                right++;
            }
            else{
                st.remove(s.charAt(left++));
            }   
        }
        return max;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLength = 0;
//         Set<Character> set = new HashSet<>();

//         int left = 0;
//         int right = 0;

//         while(right < s.length()) {
//             if(!set.contains(s.charAt(right))) {
//                 set.add(s.charAt(right));
//                 maxLength = Math.max(maxLength, set.size());
//                 right++;
//             }
//             else {
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//         }


//         return maxLength;
//     }
// }