package org.example.new_approach.bfs.practice.problem_1;

public class App {
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        a.addNeighbour(b);
        a.addNeighbour(c);
        b.addNeighbour(a);
        b.addNeighbour(d);
        b.addNeighbour(e);
        d.addNeighbour(b);
        e.addNeighbour(b);
        f.addNeighbour(c);

    }
}
