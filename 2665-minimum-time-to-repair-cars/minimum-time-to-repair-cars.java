class Solution {

    // Helper method to check if a given time is sufficient to repair the required number of cars
    public boolean timeIsSuff(int[] ranks, int cars, long minGiven) {
        long carsDone = 0;

        // Iterate through each mechanic's rank
        for (int r : ranks) {
            // The formula for the number of cars a mechanic can repair in 'minGiven' time:
            // Time required for one car = r * (cars^2)
            // Rearranging it to calculate the maximum number of cars possible in 'minGiven' time:
            // cars = sqrt(minGiven / r)
            long c2 = minGiven / r;   // Max possible time for this mechanic
            long c = (long) Math.sqrt(c2); // Calculate the number of cars using square root logic
            carsDone += c;  // Accumulate total cars repaired
        }

        // If the total cars repaired meet or exceed the required count, return true
        return carsDone >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        // Binary search on the possible time range
        long l = 1, r = (long) 1e14; // Upper limit is a large number based on problem constraints

        // Binary search loop to minimize the time
        while (l < r) {
            long mid = (l + r) / 2; // Calculate mid-point of the search range

            // Check if 'mid' time is sufficient
            if (timeIsSuff(ranks, cars, mid)) {
                r = mid; // Try to minimize the time by reducing the upper limit
            } else {
                l = mid + 1; // Increase the lower limit if 'mid' is insufficient
            }
        }

        // The binary search converges on the minimum sufficient time
        return l;
    }
}
