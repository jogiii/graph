package org.example.challenges.maze_escape;

import java.util.Stack;

public class MazeSolverIterative {

    static class Cell{
        int x;
        int y;
        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static boolean solveMaze(int[][] maze, int startX, int startY){
        int rows = maze.length;
        int cols = maze.length;

        boolean[][] visited = new boolean[rows][cols];

        Stack<Cell> stack = new Stack<>();

        stack.push(new Cell(startX, startY));

        // Movement directions :Down, Up, Right, Left
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!stack.isEmpty()){
            Cell current = stack.pop();

            int x = current.x;
            int y = current.y;

            //if we reach the destination, return true
            if(maze[x][y] == maze.length){
                System.out.println("solution exists...");
                return true;
            }

            visited[x][y] = true;

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(isFeasible(maze,visited,newX,newY)){
                    stack.push(new Cell(newX, newY));
                }
            }
        }
        System.out.println("solution does not exist...");
        return false; // stack is empty, no path exists
    }

    private static boolean isFeasible(int[][] maze, boolean[][] visited, int x, int y) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Check boundaries FIRST to avoid ArrayIndexOutOfBoundsException
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return false;
        }

        // Check if the cell is a wall (1) or already visited
        return maze[x][y] != 1 && !visited[x][y];
    }


}
