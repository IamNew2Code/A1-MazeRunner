package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class TileTest {
    Tile firstTile;

    @BeforeEach
    public void setUp(){
        this.firstTile = Tile.createTile(new Position(0,0), Type.WALL);
    }

    @Test
    public void sampleTest() {
        Tile overwriteTile = Tile.createTile(new Position(0, 0), Type.PASS);
        assertEquals(overwriteTile, this.firstTile);
    }
}
