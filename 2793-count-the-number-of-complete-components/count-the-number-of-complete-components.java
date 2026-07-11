import java.util.*;

public class Solution {

    // Method to count the number of complete components in a graph
    public int countCompleteComponents(int n, int[][] edges) {
        // Adjacency lists for each vertex
        // Each index in 'graph' represents a vertex, and its corresponding list stores
        // connected vertices.
        List<Integer>[] graph = new ArrayList[n];

        // Map to store the frequency of each unique adjacency list (representing graph
        // structure)
        Map<List<Integer>, Integer> componentFreq = new HashMap<>();

        // Initialize adjacency lists with self-loops (each vertex is initially
        // connected to itself)
        // This ensures that isolated nodes are treated as their own "component."
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
            graph[vertex].add(vertex); // Self-loop
        }

        // Build the adjacency lists from the given edges
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]); // Add connection for vertex 0
            graph[edge[1]].add(edge[0]); // Add connection for vertex 1
        }

        // Count frequency of each unique adjacency pattern
        for (int vertex = 0; vertex < n; vertex++) {
            List<Integer> neighbors = graph[vertex];
            Collections.sort(neighbors); // Sorting ensures consistency when comparing identical patterns
            componentFreq.put(
                    neighbors,
                    componentFreq.getOrDefault(neighbors, 0) + 1);
        }

        // Identify complete components by checking if the pattern size matches its
        // frequency
        int completeCount = 0;
        for (Map.Entry<List<Integer>, Integer> entry : componentFreq.entrySet()) {
            if (entry.getKey().size() == entry.getValue()) {
                completeCount++;
            }
        }

        return completeCount;
    }
}
