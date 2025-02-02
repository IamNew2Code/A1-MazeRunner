package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    
    private static final Logger logger = LogManager.getLogger();
    private String mazeTextFile;
    private List<List<Tile>> maze = new ArrayList<List<Tile>>();
    private int totalRow;
    private int totalCol;

    public List<List<Tile>> getMaze(){
        return this.maze;
    }

    public void setMaze(String mazeTextFile){
        this.mazeTextFile = mazeTextFile;
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
        for(List<Tile> row: this.maze){
            if(row.get(0).type == Type.PASS){
                return row.get(0);
            }
        } 
        logger.error("No start position was found");
        return new Tile(null, null);
    }

    public Tile getEndTile(){
        for(List<Tile> row: this.maze){
            if(row.get(this.totalCol-1).type == Type.PASS){
                return row.get(totalCol-1);
            }
        } 
        logger.error("No start position was found");
        return new Tile(null, null);
    }

    public void convertMazeTextFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.mazeTextFile));

            String line; 
            int row = 0;
            while ((line = reader.readLine()) != null) {
                List<Tile> temp = new ArrayList<>();
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '#') {
                        temp.add(new Tile(new Position(row, col), Type.WALL));
                    } else if (line.charAt(col) == ' ') {
                        temp.add(new Tile(new Position(row, col), Type.PASS));
                    }
                }
                maze.add(temp);
                row++;
            }
            this.totalRow = row;
            this.totalCol = maze.get(0).size();

        } catch(Exception e) {
            logger.error("An error has occured in convertMazeTextFile");
        }
        
    }

    public void printMaze(){
        for(List<Tile> i : maze){
            for(Tile j : i){
                System.out.print(j.type + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }

}