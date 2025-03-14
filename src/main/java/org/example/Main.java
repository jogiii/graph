package org.example;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");

        graph.printGraph();
        System.out.println("Performing BFS from A:");
        graph.bfs("A");


        System.out.println("DFS traversal starting from A:");
        graph.dfs("A");

        }
    }

