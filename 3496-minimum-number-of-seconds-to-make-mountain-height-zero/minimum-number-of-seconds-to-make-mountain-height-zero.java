import java.util.*;

class Solution {

    public long minNumberOfSeconds(int h, int[] t) {

        /*
            Priority queue stores:
            [nextCompletionTime, workerId, tasksDoneByWorker]

            We always process the worker who can finish
            the next task earliest.
        */
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        /*
            Initially each worker can finish their
            first task in t[i] seconds.
        */
        for (int i = 0; i < t.length; i++) {
            pq.add(new long[]{t[i], i, 1});
        }

        long resultTime = 0;

        /*
            We must complete h tasks.
            Each iteration assigns the next task
            to the worker who becomes free earliest.
        */
        while (h > 0) {

            long[] current = pq.poll();

            long completionTime = current[0];
            int workerId = (int) current[1];
            int tasksDone = (int) current[2];

            /*
                This worker finishes the current task
                at completionTime.
            */
            resultTime = completionTime;

            h--;

            /*
                If more tasks remain, compute when this
                worker will finish the next one.
            */
            if (h > 0) {

                long nextTaskIndex = tasksDone + 1;

                /*
                    Time for worker i after doing k tasks:

                    t[i] * (1 + 2 + ... + k)
                    = t[i] * (k * (k + 1) / 2)

                    So we compute the time for the
                    next completion.
                */
                long nextTime =
                    (long) t[workerId] *
                    (nextTaskIndex * (nextTaskIndex + 1) / 2);

                pq.add(new long[]{nextTime, workerId, (int) nextTaskIndex});
            }
        }

        return resultTime;
    }
}