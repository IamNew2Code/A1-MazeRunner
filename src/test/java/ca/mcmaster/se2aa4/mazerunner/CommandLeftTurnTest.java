package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommandLeftTurnTest {
    private Command leftTurn = new LeftTurnCommand(new Position(1,1), CardinalDirection.SOUTH);

    @Test
    public void testDirectionBeforeExecute(){

        CardinalDirection directionBeforeLeftTurnExecute = leftTurn.getDirection();
        assertEquals(CardinalDirection.SOUTH, directionBeforeLeftTurnExecute);
    }

    @Test
    public void testPositionBeforeExecute(){
        Position directionBeforeLeftTurnExecute = leftTurn.getPosition();
        assertEquals(new Position(1,1), directionBeforeLeftTurnExecute);
    }

    @Test
    public void testDirectionPositionAfterExecute(){

        leftTurn.execute();
        CardinalDirection directionAfterLeftTurnExecute = leftTurn.getDirection();
        assertEquals(CardinalDirection.EAST, directionAfterLeftTurnExecute);

        Position positionAfterLeftTurnExecute = leftTurn.getPosition();
        assertEquals(new Position(1,2), positionAfterLeftTurnExecute);
    }
}
