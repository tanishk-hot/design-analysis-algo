import java.util.Arrays;
import java.util.PriorityQueue;

public class TSPBranchAndBound {

    static int N; // Number of cities
    static int[][] costMatrix; // The cost matrix

    // Node class to store a partial tour, its cost, and its current bound
    static class Node implements Comparable<Node> {
        int[] path;      // Current path of the cities visited
        int level;       // Level of the node in the tree (number of cities visited)
        int bound;       // Lower bound of the node
        int cost;        // Current cost of the path

        // Constructor
        Node(int[] path, int level, int cost, int bound) {
            this.path = path.clone();
            this.level = level;
            this.cost = cost;
            this.bound = bound;
        }

        // Compare nodes based on their bound (for priority queue)
        public int compareTo(Node other) {
            return this.bound - other.bound;
        }
    }

    // Function to calculate the lower bound of a node
    static int calculateBound(Node node) {
        int bound = node.cost;
        boolean[] visited = new boolean[N];

        // Mark visited cities
        for (int i = 0; i <= node.level; i++) {
            visited[node.path[i]] = true;
        }

        // For each unvisited city, add the minimum cost edge
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int minCost = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && i != j) {
                        minCost = Math.min(minCost, costMatrix[i][j]);
                    }
                }
                bound += minCost;
            }
        }
        return bound;
    }

    // Function to solve TSP using Branch and Bound
    static int solveTSP() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] initialPath = new int[N + 1]; // Store cities in path

        // Start from city 0
        initialPath[0] = 0;

        // Create the root node
        Node root = new Node(initialPath, 0, 0, calculateBound(new Node(initialPath, 0, 0, 0)));

        // Add root node to the priority queue
        pq.add(root);

        // Track the minimum cost and path
        int minCost = Integer.MAX_VALUE;
        int[] bestPath = null;

        // Branch and Bound Loop
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // Prune the node if its bound exceeds the minimum cost found so far
            if (current.bound < minCost) {
                // If we've visited all cities and are back at the start, check if it's a better solution
                if (current.level == N - 1) {
                    int lastCost = costMatrix[current.path[current.level]][current.path[0]];
                    if (lastCost != Integer.MAX_VALUE && current.cost + lastCost < minCost) {
                        minCost = current.cost + lastCost;
                        bestPath = current.path.clone();
                        bestPath[N] = bestPath[0]; // Complete the cycle
                    }
                } else {
                    // Branch out to other cities
                    for (int i = 1; i < N; i++) {
                        if (!isCityVisited(current.path, current.level, i)) {
                            int[] newPath = current.path.clone();
                            newPath[current.level + 1] = i;
                            int newCost = current.cost + costMatrix[current.path[current.level]][i];
                            Node childNode = new Node(newPath, current.level + 1, newCost, 0);
                            childNode.bound = calculateBound(childNode);

                            // If the bound is better than the current minCost, add it to the PQ
                            if (childNode.bound < minCost) {
                                pq.add(childNode);
                            }
                        }
                    }
                }
            }
        }

        // Print the best path found
        if (bestPath != null) {
            System.out.println("Best Path: " + Arrays.toString(bestPath));
        }

        return minCost;
    }

    // Helper function to check if a city has been visited in the current path
    static boolean isCityVisited(int[] path, int level, int city) {
        for (int i = 0; i <= level; i++) {
            if (path[i] == city) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N = 4; // Number of cities
        costMatrix = new int[][]{
                {Integer.MAX_VALUE, 10, 15, 20},
                {10, Integer.MAX_VALUE, 35, 25},
                {15, 35, Integer.MAX_VALUE, 30},
                {20, 25, 30, Integer.MAX_VALUE}
        };

        int minCost = solveTSP();
        System.out.println("Minimum cost of TSP: " + minCost);
    }
}


/*
Output:

Best Path: [0, 1, 3, 2, 0]
Minimum cost of TSP: 80

* */