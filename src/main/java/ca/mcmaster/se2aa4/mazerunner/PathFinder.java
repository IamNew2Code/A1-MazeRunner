package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PathFinder {
    private Position mazeStart;
    private Position mazeExit;
    private Maze maze;
    private List<String> finalPath = new ArrayList<>();
    private StringBuilder currPath = new StringBuilder();
    private String direction = "DLRU";
    
    //visitedPositions is an array list that keeps track of which tiles we have been visited to avoid looping or revisiting dead ends
    private List<Position> visitedPositions = new ArrayList<>();

    //keeps track of the tiles we are passing in the Maze (2d array) 
    Stack<Position> pathStack = new Stack<>();

    private int[] dr = { 1, 0, 0, -1 };
    private int[] dc = { 0, -1, 1, 0 };
    

    public void setMaze(Maze maze){
        this.maze = maze;

    }

    public void findStartandEndPosition(){

        this.mazeStart = this.maze.getStartTile().position;
        this.mazeExit = this.maze.getEndTile().position;
    }

    //reference: https://medium.com/@amrmohamed81298/maze-solver-visualizer-a-journey-through-dfs-bfs-and-a-algorithms-in-practice-02d719b0bce6
    public void findPath(){

        //current position will be set to the start position
        Position currentPos = this.mazeStart;

        this.visitedPositions.add(currentPos);
        this.pathStack.push(currentPos);

        while (!currentPos.positionEqual(this.mazeExit)) {
            
            //keeps track if we have advanced to a new tile
            boolean moved = false;

            //since there are 4 tiles we can go to, try all 4 of them
            for (int i = 0; i < 4; i++) {
                int newRow = currentPos.getRow() + this.dr[i];
                int newCol = currentPos.getCol() + this.dc[i];

                //check if the desired tile we want to visit is valid
                if (isValid(newRow, newCol)) {
                    currentPos = new Position(newRow, newCol);
                    this.visitedPositions.add(currentPos);
                    this.pathStack.push(currentPos); 
                    moved = true;
                    break;
                }
            }
            
            // If there are no tiles that we are able to visit then we need to back track
            if (!moved) {
                if (!this.pathStack.isEmpty()) {

                    //by poping the position of the tile we can simulate going backwards
                    this.pathStack.pop();

                    //set the currentPos to the tile before we reach the dead end
                    currentPos = this.pathStack.peek();
                }
            }
        }

    }
    
    public boolean isValid(int row, int col){
        boolean visited = false;
        Position tempNewPosition = new Position(row, col);

        //if the row or col of the new position we are trying to go to is not within the bounds of the maze don't go to it
        if (row < 0 || row >= this.maze.getTotalRow()) return false;
        if (col <0 || col >= this.maze.getTotalCol()) return false;

        //checks if the new position we want to go to is equal to any of the positions we have visited already
        //if it is true we dont want to go to it because we might loop, so if it is false we want to go to it
        for (Position i: this.visitedPositions){
            if (tempNewPosition.positionEqual(i)){
                visited = true;
                break;
            }
        }

        return this.maze.getTile(tempNewPosition).validPath() && !visited;
    }
        

    /* 
        in the future need to implement going forward based on the direction

            Point east:
                L goes to north
                R goes to south
                F (+1 to column value)
            
            Point South:
                L goes to east
                R goes to west
                F (+1 to row value)

            Point west:
                L goes to south
                R goes to north
                F (-1 to column value)

            Point North:
                L goes to west
                R goes to east
                F (-1 to row value)
    */

    public List<String> getFinalPath(){
        Stack<Position> tempStack = new Stack<>();
        Position tempPos = new Position(0, 0);
        while(!pathStack.empty()){
            tempStack.add(pathStack.pop());
        }

        while (!tempStack.empty()) {
            tempPos = tempStack.pop();
            finalPath.add(tempPos.getRow() + "," + tempPos.getCol());
        }

        System.out.println("RESULT:");
        for(String i: finalPath){
            System.out.print(i + " ");
        }
        return finalPath;
    }


}
