package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    int row;
    int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public boolean positionEqual(Position compared){
        if (this.row == compared.getRow() && this.col == compared.getCol()) {
            return true;
        } else {
            return false;
        }
    }
}
