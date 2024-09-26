//Approach -1
class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Increment the start time and decrement the end time in the map
        map.put(start, map.getOrDefault(start, 0) + 1); // Add 1 to start time
        map.put(end, map.getOrDefault(end, 0) - 1); // Subtract 1 from end time

        int ongoing = 0;
        // Traverse through the map to check for any double booking
        for (int value : map.values()) {
            ongoing += value;
            if (ongoing > 1) {
                // If there's an overlap, revert the changes and return false
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start); // Remove if count is zero
                }
                map.put(end, map.get(end) + 1);
                if (map.get(end) == 0) {
                    map.remove(end); // Remove if count is zero
                }
                return false; // Return false if a double booking is detected
            }
        }

        return true; // Return true if the event is successfully booked
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */