package ca.mcmaster.se2aa4.mazerunner;

public class Tile {
    Position position;
    Type type;

    public Tile(Position position, Type type){
        this.position = position;
        this.type = type;
    }

    public Position getPosition(){
        return this.position;
    }

    public void changeType(Type type){
        this.type = type;
    }

    public boolean validPath(){
        if(this.type == Type.PASS){
            return true;
        } else{
            return false;
        }
    }
}