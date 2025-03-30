package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    
    private static final Logger logger = LogManager.getLogger();
    private final String mazeTextFile;
    private static final List<List<Tile>> maze = new ArrayList<List<Tile>>();
    private int totalRow;
    private int totalCol;

    public Maze(String mazeTextFile){
        this.mazeTextFile = mazeTextFile;
    }

    public List<List<Tile>> getMaze(){
        return maze;
    }

    public Tile getTile(Position position){
        return maze.get(position.getRow()).get(position.getCol());
    }

    public int getTotalRow(){
        return this.totalRow;
    }

    public int getTotalCol(){
        return this.totalCol;
    }

    public Tile getStartTile(){
        for(List<Tile> row: maze){
            if(row.get(0).getType() == Type.PASS){
                return row.get(0);
            }
        } 
        logger.error("No start position was found");
        return null;
    }

    public Tile getEndTile(){
        for(List<Tile> row: maze){
            if(row.get(this.totalCol-1).getType() == Type.PASS){
                return row.get(totalCol-1);
            }
        } 
        logger.error("No start position was found");
        return null;
    }

    public void convertMazeTextFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.mazeTextFile));
            String line; 
            int row = 0;
            while ((line = reader.readLine()) != null) {
                List<Tile> tempArray = new ArrayList<>();
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '#') {
                        Tile newTile = Tile.createTile(new Position(row, col), Type.WALL);
                        tempArray.add(newTile);
                    } else if (line.charAt(col) == ' ') {
                        Tile newTile = Tile.createTile(new Position(row, col), Type.PASS);
                        tempArray.add(newTile);
                    }
                }
                maze.add(tempArray);
                row++;
            }
            this.totalRow = row;
            this.totalCol = maze.get(0).size();

        } catch(Exception e) {
            logger.error("An error has occured in convertMazeTextFile");
        }
        
    }

}