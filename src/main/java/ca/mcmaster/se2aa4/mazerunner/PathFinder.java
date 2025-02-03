package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathFinder {
    private Position mazeStart;
    private Position mazeExit;
    private Maze maze;
    private List<String> finalPath = new ArrayList<>();
    
    //visitedPositions is an array list that keeps track of which tiles we have been visited to avoid looping or revisiting dead ends
    private List<Position> visitedPositions = new ArrayList<>();

    //keeps track of the tiles we are passing in the Maze (2d array) 
    Stack<Position> pathStack = new Stack<>();
    Stack<CardinalDirection> directionStack = new Stack<>();

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
        CardinalDirection currentDir = CardinalDirection.EAST;

        this.visitedPositions.add(currentPos);
        this.pathStack.push(currentPos);
        this.directionStack.push(currentDir);


        while (!currentPos.positionEqual(this.mazeExit)) {
            
            //keeps track if we have advanced to a new tile
            boolean moved = false;

            //since there are 4 tiles we can go to, try all 4 of them
            for (int i = 0; i < 4; i++) {
                int newRow = currentPos.getRow() + this.dr[i];
                int newCol = currentPos.getCol() + this.dc[i];

                //check if the desired tile we want to visit is valid
                if (isValid(newRow, newCol)) {
                    
                    Position newPos = new Position(newRow, newCol);
                    Movement move = new Movement(currentDir, currentPos, newPos);
                    move.determineNewDirection();

                    currentDir = move.getDirection();

                    currentPos = newPos;
                    
                    //currentPos = new Position(newRow, newCol);

                    this.visitedPositions.add(currentPos);
                    this.pathStack.push(currentPos); 
                    this.directionStack.push(currentDir);
                    this.finalPath.add(move.getMovement());
                    moved = true;
                    break;
                }
            }
            
            // If there are no tiles that we are able to visit then we need to back track
            if (!moved) {
                if (!this.pathStack.isEmpty()) {

                    //by poping the position of the tile we can simulate going backwards
                    this.pathStack.pop();
                    this.directionStack.pop();
                    this.finalPath.remove(this.finalPath.size()-1);

                    //set the currentPos to the tile before we reach the dead end
                    currentPos = this.pathStack.peek();
                    currentDir = this.directionStack.peek();
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

    public String getFinalPath(){

        //used to convert the finalPath array list into a String 
        //used an array in the first place to simulate the backtracking capability in the path algorithm
        StringBuilder temp = new StringBuilder();

        for(String i: this.finalPath){
            temp.append(i);
        }
        
        String calculatedPath = temp.toString();

        return calculatedPath;
    }


}
