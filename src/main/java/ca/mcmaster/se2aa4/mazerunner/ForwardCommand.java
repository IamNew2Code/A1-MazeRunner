package ca.mcmaster.se2aa4.mazerunner;

public class ForwardCommand extends Command {
     
    public ForwardCommand(Position currPosition, CardinalDirection currDirection){
        super(currPosition, currDirection);

    }

    @Override
    //To go forward we do not need to update the direction as we should be going in the same direction
    //updates the super currPosition to the new one so that it can be used when back tracking
    public void execute() {
        if(this.currDirection.equals(CardinalDirection.EAST)){
            this.currPosition = new Position(currPosition.getRow(), currPosition.getCol()+1);
        } else if(this.currDirection.equals(CardinalDirection.WEST)){
            this.currPosition = new Position(currPosition.getRow(), currPosition.getCol()-1);
        } else if(this.currDirection.equals(CardinalDirection.NORTH)){
            this.currPosition = new Position(currPosition.getRow()-1, currPosition.getCol());
        } else if(this.currDirection.equals(CardinalDirection.SOUTH)){
            this.currPosition = new Position(currPosition.getRow()+1, currPosition.getCol());
        }
    }

    @Override
    public String getCommandString(){
        return "F";
    }
}
