package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    private Tile firstTile = Tile.createTile(new Position(9995,9995), Type.WALL);

    @Test
    //prevents creating/overwriting a Tile to a position if there already exists a Tile for it  
    public void testCreateTileOnSamePositionWithDifferentType() {
        Tile overwriteTile = Tile.createTile(new Position(9995, 9995), Type.PASS);
        assertEquals(overwriteTile, firstTile);
    }

    @Test
    public void testSameInstanceForSamePosition(){
        Tile sameTile = Tile.createTile(new Position(9995, 9995), Type.WALL);
        assertEquals(sameTile, firstTile);
    }

    @Test
    public void testDifferentPositions(){
        Tile newTile = Tile.createTile(new Position(9996,9996), Type.PASS);
        assertNotEquals(newTile, firstTile);
    }

    @Test
    //tests if getPosition() returns the correct position
    public void testGetPosition(){
        Position p = new Position(9995,9995);
        assertEquals(p, firstTile.getPosition());
    }

    @Test
    //tests if getType() returns the correct type
    public void testGetType(){
        Type t = Type.WALL;
        assertEquals(t, firstTile.getType());
    }

    @Test
    //tests if validPath returns true if the type is PASS and false if the type is WALL
    public void testValidPath(){
        Tile passTile = Tile.createTile(new Position(9997,9997), Type.PASS);
        assertEquals(passTile.validPath(), true);

        Tile failTile = Tile.createTile(new Position(9998,9998), Type.WALL);
        assertEquals(failTile.validPath(), false);
    }

    @Test
    public void testNullType(){
        //tests if createTile has two null parameters
        Tile bothParamNullTile = Tile.createTile(null, null);
        assertEquals(null, bothParamNullTile.getPosition());
        assertEquals(null, bothParamNullTile.getType());

        //tests if createTile only has a null position
        Tile positionNullTile = Tile.createTile(null, Type.PASS);
        assertEquals(null, positionNullTile.getPosition());
        assertEquals(null, positionNullTile.getType());

        //tests if createTile only has a null type
        Position p = new Position(9999,9999);
        Tile typeNullTile = Tile.createTile(p, null);
        assertEquals(p, typeNullTile.getPosition());
        assertEquals(null, typeNullTile.getType());
    }

}
