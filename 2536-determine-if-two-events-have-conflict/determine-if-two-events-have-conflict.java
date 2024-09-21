class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Converting times to minutes
        int start1 = convertToMinutes(event1[0]);
        int end1 = convertToMinutes(event1[1]);
        int start2 = convertToMinutes(event2[0]);
        int end2 = convertToMinutes(event2[1]);

        // Checking if the events overlap
        return !(end1 < start2 || end2 < start1);
    }

    // Helper function to convert HH:MM to total minutes since midnight
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

}