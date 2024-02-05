// class Solution {
//     public int trailingZeroes(int n) {
//         return n/5+n/25+n/125+n/625+n/3125;
//     }
// }
public class Solution {
    // public int trailingZeroes(int n) {
    // int count = 0;
    // int i = 5;
    // while (n / i >= 1) {
    // count += n / i;
    // i *= 5;
    // }
    // return count;
    // }
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
