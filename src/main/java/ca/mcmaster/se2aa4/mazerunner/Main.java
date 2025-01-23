package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("i", true, "maze text file");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);
        String mazeTextFile = cmd.getOptionValue("i");

        logger.info("** Starting Maze Runner");

        Maze maze = new Maze();
        maze.setMaze(mazeTextFile);
        maze.convertMazeTextFile();
        maze.printMaze();
        
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
