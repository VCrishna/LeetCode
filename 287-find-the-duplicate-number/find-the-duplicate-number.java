class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                nums[index] *= -1; // Marking the duplicate by negating the value
                return index; // Returning the duplicate number
            }
            nums[index] *= -1; // Marking the visited number by negating the value
        }
        return 0; // Default return value if no duplicate found (assuming 0 is not in the array)
    }

    public int findDuplicate_SET(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return i; // Returning the duplicate number found in the set
            }
            set.add(i); // Adding each element to the set
        }
        return 0; // Default return value if no duplicate found (assuming 0 is not in the array)
    }

    public int findDuplicate_SORTING(int[] nums) {
        Arrays.sort(nums); // Sorting the array in non-decreasing order
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) // If adjacent elements are equal, it's a duplicate
                return nums[i]; // Returning the duplicate number
        }
        return 0; // Default return value if no duplicate found (assuming 0 is not in the array)
    }

}