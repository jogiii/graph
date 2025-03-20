package org.example.new_approach.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {


    private String name;
    private boolean visited;
    private List<Vertex> adjList;
    public Vertex(String name) {
        this.name = name;
        this.adjList = new ArrayList<Vertex>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjList() {
        return adjList;
    }

    public void addNeighbour(Vertex vertex) {
        this.adjList.add(vertex);
    }
}
