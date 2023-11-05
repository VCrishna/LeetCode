class Solution {
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int consecutiveWins = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                consecutiveWins = 1;
            }
            else {
                consecutiveWins++;
            }
            if(consecutiveWins == k) 
                return max;
        }

        return max;
    }
    public int getWinner_BRUTE_FORCE(int[] arr, int k) {
        int result = 0;
        int count = 0;
        while (count < k) {
            int first = arr[0];
            int second = arr[1];
            if (first > second) {
                // move secound element to the last, update result and increment count
                result = first;
                for(int i = 2; i < arr.length; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length - 1] = second;
                count++;

            }
            else {
                // move secound element to the last, update result and reset count to 1
                result = second;
                arr[0] = second;
                for(int i = 2; i < arr.length; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length - 1] = first;
                count = 1;
            }
        }
        return result;
    }
}
