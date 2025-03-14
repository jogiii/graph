package org.example;

import java.util.*;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }


    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;

        }
        return false;

    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;

    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }


    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);

        }
        adjList.remove(vertex);
        return true;
    }

    public void bfs(String startVertex) {
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Graph does not contain vertex " + startVertex);
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        System.out.println("BFS Traversal for vertex " + startVertex);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            System.out.println(currentVertex);

            for (String neighbor : adjList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }




    }

    public void dfs(String startVertex){

        if (!adjList.containsKey(startVertex)) return;
        HashSet<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(startVertex);

        while(!stack.isEmpty()){
            String currentVertex = stack.pop();

            if(!visited.contains(currentVertex)){
                System.out.println(currentVertex+" ");
                visited.add(currentVertex);

                //push neighbours onto the stack

                List<String> neighbors = adjList.get(currentVertex);

                Collections.reverse(neighbors); //reverse to maintain correct DFS order

                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

    }




































}
