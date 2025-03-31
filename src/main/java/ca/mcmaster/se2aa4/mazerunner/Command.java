package ca.mcmaster.se2aa4.mazerunner;

public abstract class Command {
    public Position currPosition;
    public CardinalDirection currDirection; 

    Command(Position currPosition, CardinalDirection currDirection){
        this.currPosition = currPosition;
        this.currDirection = currDirection;
    }

    public CardinalDirection getDirection(){
        return this.currDirection;
    }

    public Position getPosition(){
        return this.currPosition;
    }

    public abstract void execute();

    public abstract String getCommandString();

}
