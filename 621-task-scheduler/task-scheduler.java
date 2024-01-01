class Solution {

    public int leastInterval(char[] tasks, int n) {
        // Array to store the count of each task (assuming uppercase letters)
        int[] counts = new int[26];

        // Counting occurrences of each task
        for (char elem : tasks) {
            counts[elem - 'A']++;
        }

        // Sorting the counts array to have the maximum count at the end
        Arrays.sort(counts);

        // The maximum value (count) of a task
        // -1 because for last task there is no need to stay idle
        int maxValue = counts[25] - 1;

        // Calculate the total idle slots
        int idleSlots = maxValue * n;

        // Iterate through the counts array in reverse to distribute idle slots
        for (int i = 24; i >= 0; i--) {
            // Subtract the minimum of maxValue and the current count from idleSlots
            idleSlots -= Math.min(maxValue, counts[i]);
        }

        // If idleSlots is negative, return the total number of tasks,
        // otherwise, return idleSlots plus the total number of tasks
        return idleSlots < 0 ? tasks.length : idleSlots + tasks.length;
    }

    // Easy Method
    public int leastInterval_EASY(char[] tasks, int n) {
        int[] counts = new int[26];

        // Counting occurances of each task
        for (char elem : tasks) {
            counts[elem - 'A']++;
        }

        // Finding max or biggest task in the total tasks
        int max = 0;
        for (int count : counts) {
            if (count > max) max = count;
        }

        // minimun required cycles
        // if a task occured for 10 time
        // we dont take idle time for last set of tasks so (max - 1)
        // and this should occur for n + 1 --> n = cool down period
        // after n tasks adding 1 (i.e., cooling period)
        // we get minimum cycles
        int minReq = (max - 1) * (n + 1);

        // finding similar tasks which are of max count
        int similar = 0;
        for (int count : counts) {
            if (count == max) similar++;
        }

        // max of tasks length or sum of similar tasks & minimum cycles required
        return Math.max(minReq + similar, tasks.length);
    }
    // My Method
    // public int leastInterval(char[] tasks, int n) {
    //     Map<Character,Integer> map = new HashMap<>();
    //     int result = 0;
    //     // Filling the HashMap with each character and it's count
    //     for(char c : tasks)
    //         map.put(c, map.getOrDefault(c,0)+1);
    //     // map.forEach((x,y)-> System.out.println(x+" "+y));

    //     // Max Heap
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    //     // Adding all the values to the heap so that we get max value in constant time
    //     maxHeap.addAll(map.values());
    //     // we need to process until the heap is empty
    //     while (!maxHeap.isEmpty()) {
    //         // temporary list which hold the values that are processes in this cycle
    //         List<Integer> tempList = new ArrayList<>();
    //         // As we need to wait for cooldown period of n between two same tasks or
    //         // Stay ideal after n processes
    //         for (int i = 0; i < n + 1; i++) {
    //             if (!maxHeap.isEmpty()){
    //                 tempList.add(maxHeap.poll());
    //             }
    //         }
    //         // iterating over temporary list and checking do we need to still process
    //         for (int i : tempList) {
    //             // if i value is greater than 0 which mean that there are tasks which are left
    //             // and need to be processed.
    //             // If i value is greater then we are adding it back to the heap
    //             if (--i > 0) {
    //                 maxHeap.offer(i);
    //             }
    //         }
    //         // calculating result
    //         // if heap is empty which mean that we are done processing the tasks
    //         // so we are adding the size/length of temp list (i.e., no. of tasks processes in this cycle)
    //         // else we are adding cooldown period + 1 idle time
    //         result += maxHeap.isEmpty() ? tempList.size() : n + 1;
    //     }
    //     return result;
    // }
}
