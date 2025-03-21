package org.example.new_approach.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;


    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<Vertex>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex v) {
        adjacencyList.add(v);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
