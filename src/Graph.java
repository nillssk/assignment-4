import java.util.*;

public class Graph {

    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // add edge with weight
    public void addEdge(int from, int to, int weight) {
        adjacencyList.get(from).add(new Edge(from, to, weight));
    }

    // print graph
    public void printGraph() {

        for (int vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (Edge edge : adjacencyList.get(vertex)) {
                System.out.print(edge + " ");
            }

            System.out.println();
        }
    }

    // BFS traversal
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // DFS traversal
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        dfsHelper(start, visited);

        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (Edge edge : adjacencyList.get(current)) {

            int neighbor = edge.getDestination();

            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra Algorithm
    public void dijkstra(int start) {

        int size = adjacencyList.size();

        int[] distance = new int[size];
        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        for (int i = 0; i < size - 1; i++) {

            int minVertex = -1;

            for (int j = 0; j < size; j++) {

                if (!visited[j] &&
                        (minVertex == -1 ||
                                distance[j] < distance[minVertex])) {

                    minVertex = j;
                }
            }

            visited[minVertex] = true;

            for (Edge edge : adjacencyList.get(minVertex)) {

                int neighbor = edge.getDestination();
                int weight = edge.getWeight();

                if (!visited[neighbor]
                        && distance[minVertex] != Integer.MAX_VALUE
                        && distance[minVertex] + weight < distance[neighbor]) {

                    distance[neighbor] =
                            distance[minVertex] + weight;
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ":");

        for (int i = 0; i < distance.length; i++) {
            System.out.println(start + " -> " + i + " = " + distance[i]);
        }

        System.out.println();
    }
}