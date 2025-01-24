package ca.mcmaster.se2aa4.mazerunner;
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

        PathFinder path = new PathFinder();
        path.setMaze(maze);
        path.findStartPosition();
        path.findEndPosition();
        path.forward();
        logger.info("Path computed " + path.getDirections());
        logger.info("** End of MazeRunner");
    }
}
