package org.example.new_approach.dfs.with_recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        int vertexCount = 40000;  // Large number of vertices
        Random random = new Random();

        // Create vertices
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            vertices.add(new Vertex("V" + i));
        }

        // Randomly connect vertices
        for (int i = 0; i < vertexCount; i++) {
            int edges = random.nextInt(5) + 1; // Each vertex has 1-5 random neighbors
            for (int j = 0; j < edges; j++) {
                int neighborIndex = random.nextInt(vertexCount);
                if (neighborIndex != i) {
                    vertices.get(i).addNeighbour(vertices.get(neighborIndex));
                }
            }
        }

        // Perform DFS
        DepthFirstSearchRecursion dfs = new DepthFirstSearchRecursion();

        long startTime = System.currentTimeMillis();
        dfs.dfs(vertices);
        long endTime = System.currentTimeMillis();

        System.out.println("\nDFS Execution Time: " + (endTime - startTime) + " ms");


    }
}
