package org.example.challenges.maze_escape;

public class MazeSolver {

    private int[][] maze;
    private boolean [][] visited;
    private int startRow;
    private int startCol;


    public MazeSolver(int[][] maze, int startRow, int startCol) {

        this.maze = maze;
        this.visited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startCol = startCol;

    }

    public void findWay(){
        if(dfs(startRow, startCol))
            System.out.println("Solution Exists...");
        else
            System.out.println("Solution Not Exists...");
    }


    private boolean isFeasible(int x, int y){
        // we check the vertical dimension
        if(x<0 || x>maze.length-1)
            return false;

        //we check the horizontal dimension
        if(y<0 || y> maze.length-1)
            return false;

        // we have already considered that state
        if(visited[x][y])
            return false;

        // there is an obstacle in the way
        if(maze[x][y] == 1)
            return false;

        return true;
    }

    private boolean dfs(int x, int y) {

        if(x == maze.length - 1 && y == maze.length - 1)
            return true;

        if(isFeasible(x, y)){
            visited[x][y] = true;

            if(dfs(x+1, y))
                return true;

            if(dfs(x-1, y))
                return true;

            if(dfs(x, y+1))
                return true;

            if(dfs(x, y-1))
                return true;

            //BACKTRACK
            visited[x][y] = false;
            return false;

        }
        return false;
    }


}
