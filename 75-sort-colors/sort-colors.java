class Solution {
    // 1-pass is essentially the 3-way quick partition method in quicksort. 
    // check this gret video demo from Professor Robert Sedgewick
    // https://www.youtube.com/watch?v=WBFzOYJ5ybM&t=177s
    //-------------  SOLUTION 2: 1 SCAN ----------------//
    // 3-way partition used in quick sort
    public void sortColors(int[] nums) {
        int lt = 0, i = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, gt--);
            } else { // nums[i] == 1
                i++;
            }
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public void sortColors1(int[] nums) {
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                i = -1;
            }
        }

    }

    public void sortColors_MAP(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            while (value > 0) {
                nums[index++] = entry.getKey();
                value--;
            }
        }
    }
}