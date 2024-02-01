class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // Checking if the length of nums is divisible by 3
        if (nums.length % 3 != 0) {
            // If not, returning an empty 2D array
            return new int[0][0];
        }

        // Initializing a 2D array to store the result
        int[][] result = new int[nums.length / 3][3];

        // Initializing an index to keep track of the 
        // current position in the result array
        int index = 0;

        // Sorting the nums array in ascending order
        // to facilitate the division of the array
        Arrays.sort(nums);

        // Iterating through nums array in steps of 3
        for (int i = 0; i < nums.length; i += 3) {
            // Checking if the conditions for dividing the array are satisfied
            if (nums[i + 1] - nums[i] <= k && nums[i + 2] - nums[i] <= k) {
                // If conditions are met, populating the current row in the result array
                result[index][0] = nums[i];
                result[index][1] = nums[i + 1];
                result[index][2] = nums[i + 2];

                // Incrementing the index for the next row in the result array
                index++;
            } else {
                // If conditions are not met, returning an empty 2D array
                return new int[0][0];
            }
        }

        // Returning the populated result array
        return result;
    }

    public int[][] divideArray_BRUTE_FORCE(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[0][0];
        }
        int[][] result = new int[nums.length / 3][3];
        List<int[]> lst = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 1] - nums[i] <= k && nums[i + 2] - nums[i] <= k) {
                lst.add(new int[] { nums[i], nums[i + 1], nums[i + 2] });
            } else {
                return new int[0][0];
            }
        }
        int index = 0;
        for (int[] i : lst) {
            result[index++] = i;
        }
        return result;
    }
}