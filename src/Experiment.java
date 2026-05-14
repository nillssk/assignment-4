public class Experiment {

    // run bfs and dfs
    public void runTraversals(Graph g) {

        long start;
        long end;

        System.out.println("BFS Traversal:");
        start = System.nanoTime();

        g.bfs(0);

        end = System.nanoTime();

        System.out.println("BFS Time: " + (end - start) + " ns");

        System.out.println();

        System.out.println("DFS Traversal:");
        start = System.nanoTime();

        g.dfs(0);

        end = System.nanoTime();

        System.out.println("DFS Time: " + (end - start) + " ns");

        System.out.println("----------------------------");
    }

    // create graph
    public Graph createGraph(int size) {

        Graph g = new Graph();

        // add vertices
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        // add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);

        g.addEdge(1, 3);
        g.addEdge(1, 4);

        g.addEdge(2, 5);
        g.addEdge(2, 6);

        g.addEdge(3, 7);

        g.addEdge(4, 8);

        g.addEdge(5, 9);

// extra edges for larger graphs
        for (int i = 10; i < size; i++) {

            g.addVertex(new Vertex(i));

            g.addEdge(i - 1, i);
        }
        return g;
    }

    // run all tests
    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("Graph Size: " + size);

            Graph g = createGraph(size);

            if (size == 10) {
                System.out.println("Graph Structure:");
                g.printGraph();
                System.out.println();
            }

            runTraversals(g);
        }
    }
}
