package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommandRightTurnTest {
    Command rightTurn = new RightTurnCommand(new Position(2,2), CardinalDirection.NORTH);

    @Test
    public void testDirectionBeforeExecute(){

        CardinalDirection directionBeforeRightTurnExecute = rightTurn.getDirection();
        assertEquals(CardinalDirection.NORTH, directionBeforeRightTurnExecute);
    }

    @Test
    public void testPositionBeforeExecute(){

        Position positionBeforeRightTurnExecute = rightTurn.getPosition();
        assertEquals(new Position(2,2), positionBeforeRightTurnExecute);
    }

    @Test
    public void testDirectionPositionAfterExecute(){

        rightTurn.execute();
        CardinalDirection directionAfterRightTurnExecute = rightTurn.getDirection();
        assertEquals(CardinalDirection.EAST, directionAfterRightTurnExecute);

        Position positionAfterRightTurnExecute = rightTurn.getPosition();
        assertEquals(new Position(2,3), positionAfterRightTurnExecute);
    }
}
