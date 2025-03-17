package org.example.new_approach;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void traverse(Vertex root) {

        Queue<Vertex> queue = new LinkedList<Vertex>();
        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {

            Vertex current = queue.remove();
            System.out.println(current);

            for(Vertex v :current.getAdjList()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
