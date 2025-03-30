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
    //prevents creating a Tile to a position if there already exists a Tile for it  
    public void testCreateTileOnSamePositionWithDifferentType() {
        Tile overwriteTile = Tile.createTile(new Position(0, 0), Type.PASS);
        assertEquals(overwriteTile, this.firstTile);
    }

    @Test
    public void sameInstanceForSamePosition(){
        Tile sameTile = Tile.createTile(new Position(0, 0), Type.WALL);
        assertEquals(sameTile, this.firstTile);
    }

    @Test
    public void differentPositions(){
        Tile newTile = Tile.createTile(new Position(1,1), Type.PASS);
        assertNotEquals(newTile, this.firstTile);
    }

    @Test
    public void testGetPosition(){
        Position p = new Position(0,0);
        assertEquals(p, this.firstTile.getPosition());
    }

    @Test
    public void testGetType(){
        Type t = Type.WALL;
        assertEquals(t, this.firstTile.getType());
    }

    @Test
    public void testValidPath(){
        Tile passTile = Tile.createTile(new Position(1,1), Type.PASS);
        assertEquals(passTile.validPath(), true);

        Tile failTile = Tile.createTile(new Position(2,2), Type.WALL);
        assertEquals(failTile.validPath(), false);
    }

    @Test
    public void testNullType(){
        Tile bothParamNullTile = Tile.createTile(null, null);
        assertEquals(null, bothParamNullTile.getPosition());

        assertEquals(null, bothParamNullTile.getType());

        Tile positionNullTile = Tile.createTile(null, Type.PASS);
        assertEquals(null, positionNullTile.getPosition());
        assertEquals(null, positionNullTile.getType());

        Position p = new Position(2,2);
        Tile typeNullTile = Tile.createTile(new Position(2,2), null);
        assertEquals(p, typeNullTile.getPosition());
        assertEquals(null, typeNullTile.getType());
    }

}
