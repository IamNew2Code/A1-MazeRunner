package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PathFinderTest {
    private Maze straightMaze;
    private Maze impossibleMaze;
    private String mazeTextFile;
    private PathFinder pathFinder;

    @BeforeEach
    public void testSetUp() { 

        // mazeTextFile = "src/test/resources/impossible.maz.txt";
        // impossibleMaze = new Maze(mazeTextFile);
        // impossibleMaze.convertMazeTextFile();

        mazeTextFile = "src/test/resources/straight.maz.txt";
        straightMaze = new Maze(mazeTextFile);
        straightMaze.convertMazeTextFile();

    }

    @Test
    public void testStraightMaze(){
        pathFinder = new PathFinder();
        pathFinder.setMaze(straightMaze);
        pathFinder.findPath();
        assertEquals("FFFF", pathFinder.getFinalPath());
    }

    // @Test
    // public void testImpossibleMaze(){
    //     pathFinder = new PathFinder();
    //     pathFinder.setMaze(impossibleMaze);
    //     pathFinder.findPath();
    //     assertEquals("No path found", pathFinder.getFinalPath());
    // }
}
