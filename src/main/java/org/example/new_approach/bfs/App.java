package org.example.new_approach.bfs;

public class App {

    public static void main(String[] args) {

        BreadthFirstSearch bfs = new BreadthFirstSearch();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");

        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbour(b);
        b.addNeighbour(f);
        a.addNeighbour(g);

        b.addNeighbour(a);
        b.addNeighbour(c);
        b.addNeighbour(d);

        c.addNeighbour(b);
        d.addNeighbour(b);
        d.addNeighbour(e);

        f.addNeighbour(a);

        g.addNeighbour(a);
        g.addNeighbour(h);
        h.addNeighbour(g);

        bfs.traverse(a);

    }





}
