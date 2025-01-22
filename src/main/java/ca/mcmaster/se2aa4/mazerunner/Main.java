package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
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
        try {
            logger.info("**** Reading the maze from file", mazeTextFile);
            BufferedReader reader = new BufferedReader(new FileReader(mazeTextFile));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("An error has occured");
        }
        
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
