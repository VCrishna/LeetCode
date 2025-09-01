import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue to store ClassRecord objects sorted by the increment in pass ratio
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.inc, a.inc) // Sort by descending increment
        );

        // Initialize the PriorityQueue with given classes
        for (int[] cl : classes) {
            pq.add(new ClassRecord(cl));
        }

        // Distribute the extra students to maximize the average ratio
        while (extraStudents-- > 0) {
            ClassRecord cl = pq.poll(); // Remove the class with the highest increment
            cl.addOneStudent(); // Add one student to this class
            pq.add(cl); // Re-insert the updated class back into the queue
        }

        // Calculate the final average pass ratio
        double totalAverage = 0.0;
        while (!pq.isEmpty()) {
            ClassRecord cl = pq.poll();
            totalAverage += (double) cl.pass / cl.total;
        }

        return totalAverage / classes.length;
    }
}

class ClassRecord {
    int pass; // Number of passing students
    int total; // Total number of students
    double inc; // Increment in pass ratio if one student is added

    public ClassRecord(int[] array) {
        this.pass = array[0];
        this.total = array[1];
        this.inc = calculateIncrement();
    }

    // Add one student to this class and update the increment
    public void addOneStudent() {
        pass++;
        total++;
        inc = calculateIncrement();
    }

    // Calculate the increment in pass ratio if one student is added
    private double calculateIncrement() {
        return (pass + 1.0) / (total + 1) - (double) pass / total;
    }
}