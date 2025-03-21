package org.example.new_approach.dfs.with_recursion;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearchRecursion {

    private Stack<Vertex> stack;


    public DepthFirstSearchRecursion() {
        this.stack = new Stack<>();
    }


    public void dfs(List<Vertex> vertexList) {

        for (Vertex v : vertexList) {
            if(!v.isVisited()){
                v.setVisited(true);
                dfsHelper(v);
            }
        }

    }

    private void dfsHelper(Vertex vertex) {
        System.out.println(vertex);

        for(Vertex v : vertex.getNeighbours()){
            if(!v.isVisited()){
                v.setVisited(true);
                dfsHelper(v);
            }
        }

    }
}
