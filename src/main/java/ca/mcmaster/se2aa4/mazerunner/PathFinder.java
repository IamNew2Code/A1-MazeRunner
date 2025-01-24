package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {
    private int currentRow;
    private int currentCol;
    private int endRow;
    private int endCol;
    private Maze maze;
    private String directions = "";

    public void setMaze(Maze maze){
        this.maze = maze;
    }

    public void findStartPosition(){

        char[][] copiedMaze = this.maze.getMaze();
        
        //go from the top of the column until the bottom to find if there is an open space to make the starting point
        for (int row = 0; row < copiedMaze.length; row++) {
            if(copiedMaze[row][0] == ' '){
                this.currentRow = row;
                this.currentCol = 0;
            }
        }
    }

    public void findEndPosition(){
        char[][] copiedMaze = this.maze.getMaze();
        int lastCol = copiedMaze[0].length - 1;

        for (int row = 0; row < copiedMaze.length; row++) {
            if(copiedMaze[row][lastCol] == ' '){
                this.endRow = row;
                this.endCol = lastCol;
            }
        }
    }

    public boolean reachedEnd(){
        if (currentRow == endRow && currentCol == endCol){
            return true;
        } else {
            return false;
        }
    }

    /* 
        in the future need to implement going forward based on the direction
        For example: 
            If pointing to the east and forward is called (+1 to column value)
            If pointing to the west and forward is called (-1 to column value)
            If pointing to the north and forward is called (-1 to row value)
            If pointing to the south and forward is called (+1 to column value)
    */

    //right now forward is only coded as a MVP to solve the straight.maz.txt file
    public void forward(){
        while ((this.currentRow == this.endRow && this.currentCol == this.endCol) != true){
            this.currentCol += 1;
            directions += "F";
        }
    }

    public String getDirections(){
        return this.directions;
    }


}
