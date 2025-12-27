class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Creating an array to store the count of meetings booked for each room
        var meetingCount = new int[n];

        // Priority queue to store the rooms that are currently in use.
        // It's sorted based on the end time of meetings
        var usedRooms = new PriorityQueue<long[]>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        // Priority queue to store the rooms that are not in use
        var unusedRooms = new PriorityQueue<Integer>();

        // Initializing the unused rooms queue with all available rooms
        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        // Sorting the meetings based on their start times
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Iterating through each meeting
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Checking for rooms that are available at the start time of the meeting
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room); // Adding the room back to the unused rooms queue
            }

            // If there are unused rooms, assign one to the current meeting
            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[] { end, room }); // Booking the room for the current meeting
                meetingCount[room]++; // Increment the meeting count for the booked room
            } else {
                // If no unused rooms are available,
                // finding the next available time slot and book the room accordingly
                long roomAvailabilityTime = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                usedRooms.offer(new long[] { roomAvailabilityTime + end - start, room });
                meetingCount[room]++; // Incrementing the meeting count for the booked room.
            }
        }

        // Finding the room with the maximum number of meetings booked.
        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom; // Return the room with the maximum meeting count.
    }
}