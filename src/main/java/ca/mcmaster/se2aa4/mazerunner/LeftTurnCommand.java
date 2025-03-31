package ca.mcmaster.se2aa4.mazerunner;

public class LeftTurnCommand extends Command {
     
    public LeftTurnCommand(Position currPosition, CardinalDirection currDirection){
        super(currPosition, currDirection);

    }

    @Override
    //When a left turn is called it changes the direction to the one on the left of the passed in direction
    //it also applies the left turn to the current position
    public void execute() {
        if(this.currDirection.equals(CardinalDirection.EAST)){
            this.currDirection = CardinalDirection.NORTH;
            this.currPosition = new Position(currPosition.getRow()-1, currPosition.getCol());
        } else if(this.currDirection.equals(CardinalDirection.WEST)){
            this.currDirection = CardinalDirection.SOUTH;
            this.currPosition = new Position(currPosition.getRow()+1, currPosition.getCol());
        } else if(this.currDirection.equals(CardinalDirection.NORTH)){
            this.currDirection = CardinalDirection.WEST;
            this.currPosition = new Position(currPosition.getRow(), currPosition.getCol()-1);
        } else if(this.currDirection.equals(CardinalDirection.SOUTH)){
            this.currDirection = CardinalDirection.EAST;
            this.currPosition = new Position(currPosition.getRow(), currPosition.getCol()+1);
        }
    }

    @Override
    public String getCommandString(){
        return "LF";
    }
}
