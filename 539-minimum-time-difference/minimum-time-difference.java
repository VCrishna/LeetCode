class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        // Convert the first time to minutes for wrap-around calculation later
        int firstTimeInMinutes = convertToMinutes(timePoints.get(0));

        // Initialize the minimum difference with a large number
        int minDifference = Integer.MAX_VALUE;

        // Iterate through the sorted list and calculate the differences between
        // adjacent times
        for (int i = 1; i < timePoints.size(); i++) {
            int currentDifference = findDifferenceInMinutes(timePoints.get(i), timePoints.get(i - 1));
            minDifference = Math.min(minDifference, currentDifference);
        }

        // Handle the wrap-around case (i.e., the difference between the last and first
        // time)
        int wrapAroundDifference = 1440
                - findDifferenceInMinutes(timePoints.get(timePoints.size() - 1), timePoints.get(0));
        minDifference = Math.min(minDifference, wrapAroundDifference);

        return minDifference;
    }

    // Function to convert HH:MM format time into total minutes from 00:00
    public static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // Function to find the difference in minutes between two time points
    public static int findDifferenceInMinutes(String time1, String time2) {
        int minutes1 = convertToMinutes(time1);
        int minutes2 = convertToMinutes(time2);
        return Math.abs(minutes1 - minutes2);
    }
}