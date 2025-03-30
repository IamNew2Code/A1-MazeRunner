package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("i", true, "maze text file");

        //spacing out the path results in some issues
        //i.e 4F R 3F will only register 4F, so need to type it in as 4FR3F
        options.addOption("p", true, "maze path");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        String mazeTextFile = cmd.getOptionValue("i");
        String mazeVerifier = cmd.getOptionValue("p");

        Maze maze = new Maze(mazeTextFile);
        maze.convertMazeTextFile();

        PathFinder path = new PathFinder();
        path.setMaze(maze);
        path.findStartandEndPosition();
        path.findPath();
        String calculatedPath = path.getFinalPath();

        if(mazeVerifier == null){
            Factorize factoredForm = new Factorize();
            System.out.println(factoredForm.factorizePath(calculatedPath));
        } else{
            PathChecker pathChecker = new PathChecker(mazeVerifier, calculatedPath);
            pathChecker.checkCanOrFact();

            pathChecker.formatInput();
        }

    }
}
