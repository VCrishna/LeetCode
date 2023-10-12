class Solution {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, (a, b) -> (b - a));
        int result = -1;
        // tasks.forEach(System.out::println);
        for (int i = 0; i < processorTime.size(); i++) {
            result = Math.max(result, processorTime.get(i) + tasks.get(i * 4));
        }
        return result;
    }
}
// processors n -> 4 cores each
// n * 4 -> tasks
