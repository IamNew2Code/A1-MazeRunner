package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandForwardTest {
    private Command forward = new ForwardCommand(new Position(0,0), CardinalDirection.EAST);

    @Test
    public void testDirectionBeforeExecute(){

        CardinalDirection directionBeforeForwardExecute = forward.getDirection();
        assertEquals(CardinalDirection.EAST, directionBeforeForwardExecute);
    }

    @Test
    public void testPositionBeforeExecute(){
        Position positionBeforeForwardExecute = forward.getPosition();
        assertEquals(new Position(0,0), positionBeforeForwardExecute);
    }

    @Test
    public void testDirectionPositionAfterExecute(){
        forward.execute();
        CardinalDirection directionAfterForwardExecute = forward.getDirection();
        assertEquals(CardinalDirection.EAST, directionAfterForwardExecute);

        Position positionAfterForwardExecute = forward.getPosition();
        assertEquals(new Position(0,1), positionAfterForwardExecute);
    }
}
