package org.example.new_approach.dfs;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private Stack<Vertex> stack;


    public DepthFirstSearch() {
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

    private void dfsHelper(Vertex rootVertex) {

        stack.add(rootVertex);
        rootVertex.setVisited(true);
        while (!stack.isEmpty()) {
            Vertex actualvertex = stack.pop();
            System.out.println(actualvertex);
            for(Vertex v : actualvertex.getNeighbours()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }
    }
}
