package org.example.new_approach.bfs.practice.problem_1;

import java.util.LinkedList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacentList;


    public Vertex(String name) {
        this.name = name;
        this.adjacentList = new LinkedList<Vertex>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getAdjacentList() {
        return adjacentList;
    }

    public void addNeighbour(Vertex vertex) {
        this.adjacentList.add(vertex);
    }
}
