package ca.mcmaster.se2aa4.mazerunner;

import java.util.Objects;

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

    @Override
    public boolean equals(Object position){
        if (this == position){
            return true;
        }
        if  (position == null || this.getClass() != position.getClass()){
            return false;
        }
        Position comparingPosition = (Position) position;
        return this.row == comparingPosition.getRow() && this.col == comparingPosition.getCol();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.row, this.col);
    }
}
