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
    private char[][] maze;

    public char[][] getMaze(){
        return maze;
    }

    public void setMaze(String mazeTextFile){
        this.mazeTextFile = mazeTextFile;
    }

    public void convertMazeTextFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.mazeTextFile));

            List<String> lines = new ArrayList<>();
            String line; 

            while((line = reader.readLine()) != null){
                lines.add(line);
            }

            int rows = lines.size();
            int cols = lines.get(0).length();

            this.maze = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                this.maze[i] = lines.get(i).toCharArray();
            }

        } catch(Exception e) {
            logger.error("An error has occured in convertMazeTextFile");
        }
        
    }

    public void printMaze(){
        for (char[] row : this.maze) {
            logger.info(new String(row));
        }
    }

}