import java.util.*;

class Solution {

    static class Event {
        double y, x1, x2;
        int type; // +1 = add, -1 = remove

        Event(double y, double x1, double x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        // Build events
        for (int[] s : squares) {
            double x1 = s[0];
            double y1 = s[1];
            double len = s[2];
            double x2 = x1 + len;
            double y2 = y1 + len;

            events.add(new Event(y1, x1, x2, +1));
            events.add(new Event(y2, x1, x2, -1));
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        List<double[]> active = new ArrayList<>();
        double totalArea = 0;

        // Pass 1: compute total union area
        for (int i = 0; i < events.size() - 1; i++) {
            Event e = events.get(i);
            update(active, e);

            double height = events.get(i + 1).y - e.y;
            if (height > 0) {
                totalArea += unionWidth(active) * height;
            }
        }

        double target = totalArea / 2.0;
        active.clear();
        double accumulated = 0;

        // Pass 2: find Y where area reaches half
        for (int i = 0; i < events.size() - 1; i++) {
            Event e = events.get(i);
            update(active, e);

            double y1 = e.y;
            double y2 = events.get(i + 1).y;
            double height = y2 - y1;
            if (height <= 0) continue;

            double width = unionWidth(active);
            double area = width * height;

            if (accumulated + area >= target) {
                return y1 + (target - accumulated) / width;
            }

            accumulated += area;
        }

        return events.get(events.size() - 1).y;
    }

    private void update(List<double[]> active, Event e) {
        if (e.type == 1) {
            active.add(new double[]{e.x1, e.x2});
        } else {
            for (int i = 0; i < active.size(); i++) {
                if (active.get(i)[0] == e.x1 && active.get(i)[1] == e.x2) {
                    active.remove(i);
                    break;
                }
            }
        }
    }

    private double unionWidth(List<double[]> intervals) {
        if (intervals.isEmpty()) return 0;

        intervals.sort(Comparator.comparingDouble(a -> a[0]));
        double width = 0;
        double start = intervals.get(0)[0];
        double end = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            double s = intervals.get(i)[0];
            double e = intervals.get(i)[1];
            if (s > end) {
                width += end - start;
                start = s;
                end = e;
            } else {
                end = Math.max(end, e);
            }
        }

        return width + (end - start);
    }
}
