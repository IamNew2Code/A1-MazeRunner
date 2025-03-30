package ca.mcmaster.se2aa4.mazerunner;
import java.util.Map;
import java.util.HashMap;

public class Tile {
    private final Position position;
    private final Type type;
    private static final Map<Position, Tile> TILES = new HashMap<>();

    private Tile(Position position, Type type){
        this.position = position;
        this.type = type;
    }

    public static Tile createTile(Position p, Type t){
        if(TILES.get(p) == null){
            TILES.put(p,new Tile(p, t));
        }
        return TILES.get(p);
    }

    public Position getPosition(){
        return this.position;
    }

    public Type getType(){
        return this.type;
    }

    public boolean validPath(){
        return this.type == Type.PASS;
    }
}