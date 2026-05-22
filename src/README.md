# Assignment 4: Graph Traversal and Representation System# Assignment 4: Graph Traversal and Representation System

## Project Overview

In this project, I implemented a graph traversal system using Java.

The graph was represented using an adjacency list structure.

I implemented two graph traversal algorithms:

* Breadth-First Search (BFS)
* Depth-First Search (DFS)

I also added Dijkstra’s Algorithm as a bonus task to find the shortest path in a weighted graph.

The purpose of this project was to understand how graph traversal works and compare BFS and DFS performance on graphs with different sizes.

The program was tested with:

* Small graph (10 vertices)
* Medium graph (30 vertices)
* Large graph (100 vertices)

Execution time was measured using `System.nanoTime()`.

---

# Graph Structure

A graph is a structure made of:

* Vertices (nodes)
* Edges (connections)

Example:

```text
0 -> 1 2
1 -> 3 4
2 -> 5 6
```

This project uses an adjacency list representation.

An adjacency list stores neighboring vertices for each vertex.

For Dijkstra Algorithm, the graph was updated to support weighted edges.

Example with weights:

```text
0 -> 1(4) 2(2)
1 -> 3(5)
```

Numbers in brackets represent edge weights.

---

# Class Descriptions

## Vertex Class

The `Vertex` class represents a node in the graph.

It contains:

* vertex id
* constructor
* getter
* toString() method

---

## Edge Class

The `Edge` class represents a connection between two vertices.

It contains:

* source vertex
* destination vertex
* edge weight
* getters
* toString() method

---

## Graph Class

The `Graph` class stores the graph using an adjacency list.

Main methods:

* addVertex()
* addEdge()
* printGraph()
* bfs()
* dfs()
* dijkstra()

---

## Experiment Class

The `Experiment` class is responsible for:

* running BFS and DFS
* running Dijkstra Algorithm
* measuring execution time
* testing graphs with different sizes

---

# BFS (Breadth-First Search)

## How BFS Works

BFS explores the graph level by level.

It uses a Queue data structure.

Example traversal:

```text
0 → 1 → 2 → 3 → 4
```

---

## BFS Use Cases

* shortest path problems
* network traversal
* level-order exploration

---

## BFS Time Complexity

O(V+E)

Where:

* V = number of vertices
* E = number of edges

---

# DFS (Depth-First Search)

## How DFS Works

DFS explores deeply before backtracking.

It uses recursion.

Example traversal:

```text
0 → 1 → 3 → 7 → 4
```

---

## DFS Use Cases

* path finding
* maze solving
* cycle detection

---

## DFS Time Complexity

O(V+E)

---

# Dijkstra Algorithm (Bonus Task)

## What Dijkstra Does

Dijkstra Algorithm finds the shortest path from one starting vertex to all other vertices in a weighted graph.

---

## How Dijkstra Works

The algorithm:

* starts from one vertex
* finds the smallest distance
* updates neighboring vertices
* repeats until all vertices are visited

---

## Example

```text
0 -> 1 (4)
0 -> 2 (2)
```

This means:

* edge from 0 to 1 has weight 4
* edge from 0 to 2 has weight 2

---

## Dijkstra Use Cases

* GPS navigation
* routing systems
* shortest path problems
* map applications

---

## Dijkstra Time Complexity

O(V²)

---

# Experimental Results

| Graph Size   | BFS Time  | DFS Time  |
| ------------ | --------: | --------: |
| 10 Vertices  | 1483900 ns | 353900 ns |
| 30 Vertices  | 709000 ns | 816200 ns |
| 100 Vertices | 4199200 ns | 2138100 ns |

---

# Analysis

## How does graph size affect BFS and DFS?

As graph size increases, execution time also increases because more vertices and edges must be visited.

---

## Which traversal was faster?

DFS was faster on small and large graphs in my experiments.

However, BFS performed slightly better on the medium graph.

The difference depends on graph structure and traversal order.

---

## Do results match O(V + E)?

Yes.

Both algorithms visit vertices and edges once, so the results are similar to the expected complexity.

---

## How does graph structure affect traversal order?

Traversal order depends on how vertices are connected.

BFS explores level by level, while DFS goes deeper first.

---

## When is BFS preferred over DFS?

BFS is preferred when finding the shortest path in an unweighted graph.

---

## What are the limitations of DFS?

DFS may use more recursion stack memory and can go very deep in large graphs.

---

## Why is Dijkstra useful?

Dijkstra is useful because it finds the shortest path in weighted graphs.

It is commonly used in GPS and navigation systems.

---

# Screenshots

## 1 Output

![1](docs/screenshots/output1.png)

---

## 2 Output

![2](docs/screenshots/output2.png)

---

## 3 Dijkstra Output

![3](docs/screenshots/output3.png)

---

# Reflection

This project helped me understand how graph traversal algorithms work in practice.

I learned the difference between BFS and DFS and how graph structure affects traversal order.

I also learned how weighted graphs work and how Dijkstra Algorithm finds the shortest path.

The most difficult part was understanding recursion in DFS and implementing the adjacency list correctly.

I also learned how to measure algorithm performance using `System.nanoTime()` and compare execution times for different graph sizes.