package org.example.new_approach.bfs.web_crawler;

public class App {

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.discoverWeb("https://www.bbc.com");
    }
}
