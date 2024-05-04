class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ret = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                ret++;
                right--;
                left++;
            }
            else{
                right--;
                ret++;
            }
        }

        return ret;
    }
}

// people = [3,2,2,1], limit = 3
// [1,2,2,3]
// if( 1 + 3 <= 3){
    // if true -> incrementing boat count, left and decrementing right
// }
// else moving right pointer left or decreasing right pointer which means
// counting boat count for highest value first
