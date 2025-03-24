package org.example.challenges.maze_escape;

public class App {

    /*

    Course challenge #1 - maze escape
In the previous lecture we have considered the maze problem itself. Your task is to implement an algorithm that can find the way out of a maze.

[
[1,1,1,1,1],
[1,2,0,1,1],
[1,1,0,1,1],
[1,1,0,0,0],
[1,1,1,1,3],
]
So we have a map like this

integer 1 represents walls

integer 2 is the starting point

integer 3 is the destination (so this is what we are looking for)

integer 0 represents the states we can consider (so the solution contains one or more 0 states)

So the solution should be something like this (S represents the states in the solution set):

[
[-,-,-,-,-],
[-,2,S,-,-],
[-,-,S,-,-],
[-,-,S,S,S],
[-,-,-,-,3],
]

     */

    public static void main(String[] args) {
        int [][] map = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {2, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        MazeSolver mazeSolver = new MazeSolver(map,1,0);
        mazeSolver.findWay();
    }
}
