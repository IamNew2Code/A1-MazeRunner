package ca.mcmaster.se2aa4.mazerunner;

public class Movement {
    private CardinalDirection prevFacing;
    private Position oldPos;
    private Position newPos;
    private CardinalDirection newFacing;

    public Movement(CardinalDirection facing, Position oldPosition, Position newPosition){
        this.prevFacing = facing;
        this.oldPos = oldPosition;
        this.newPos = newPosition;
    }

    public CardinalDirection getDirection(){
        return this.newFacing;
    }

    public void determineNewDirection(){
        int rowMovement = this.newPos.getRow() - this.oldPos.getRow();
        int colMovement = this.newPos.getCol() - this.oldPos.getCol();


        if (rowMovement == -1){
            this.newFacing = CardinalDirection.NORTH;
        } else if (rowMovement == 1){
            this.newFacing = CardinalDirection.SOUTH; 
        } else if (colMovement == -1) {
            this.newFacing = CardinalDirection.WEST;
        } else if (colMovement == 1) {
            this.newFacing = CardinalDirection.EAST;
        }
    }

    public String getMovement(){
        if (prevFacing == newFacing) return "F";

        switch (prevFacing) {
            case NORTH:
                if(newFacing == CardinalDirection.EAST){
                    return "RF";
                } else if (newFacing == CardinalDirection.WEST){
                    return "LF";
                }
            case SOUTH:
                if(newFacing == CardinalDirection.WEST){
                    return "RF";
                } else if (newFacing == CardinalDirection.EAST){
                    return "LF";
                }
            case EAST:
                if(newFacing == CardinalDirection.SOUTH){
                    return "RF";
                } else if (newFacing == CardinalDirection.NORTH){
                    return "LF";
                }
            case WEST:
                if(newFacing == CardinalDirection.NORTH){
                    return "RF";
                } else if (newFacing == CardinalDirection.SOUTH){
                    return "LF";
                }

            default:
                return "ERROR";
        }
    }
}
