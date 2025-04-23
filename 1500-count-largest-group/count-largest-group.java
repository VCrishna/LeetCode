class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            int sum = sumOfEle(n);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            n--;
        }
        int max = -1, result = 0;
        for(Integer i : map.values()) {
            if(i > max) {
                max = i;
            }
        }
        for(Integer i : map.values()) {
            if(i == max) {
                result++;
            }
        }
        return result;
    }

    public int sumOfEle(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}