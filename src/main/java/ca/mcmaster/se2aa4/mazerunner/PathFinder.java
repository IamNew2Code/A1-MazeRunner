package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private Position mazeStart;
    private Position mazeExit;
    private Maze maze;
    private List<String> finalPath = new ArrayList<>();
    
    //visitedPositions is an array list that keeps track of which tiles we have been visited to avoid looping or revisiting dead ends
    private List<Position> visitedPositions = new ArrayList<>();

    public void setMaze(Maze maze){
        this.maze = maze;

    }

    public void findStartandEndPosition(){

        this.mazeStart = this.maze.getStartTile().getPosition();
        this.mazeExit = this.maze.getEndTile().getPosition();
    }

    //reference: https://medium.com/@amrmohamed81298/maze-solver-visualizer-a-journey-through-dfs-bfs-and-a-algorithms-in-practice-02d719b0bce6
    public void findPath(){

        //current position will be set to the start position
        Position currentPos = this.mazeStart;
        CardinalDirection currentDir = CardinalDirection.EAST;

        this.visitedPositions.add(currentPos);

        CommandHistory history = new CommandHistory();

        while (!currentPos.equals(this.mazeExit)) {
            
            List<Command> commands = new ArrayList<Command>();
            commands.add(new LeftTurnCommand(currentPos,currentDir));
            commands.add(new RightTurnCommand(currentPos, currentDir));
            commands.add(new ForwardCommand(currentPos, currentDir));

            //keeps track if we have advanced to a new tile
            boolean moved = false;

            //since there are 4 tiles we can go to, try all 4 of them
            for (Command c: commands){
                c.execute();
                Position newPos = c.getPosition();
                //check if the desired tile we want to visit is valid
                if (isValid(newPos)) {

                    history.push(c);
                    
                    currentDir = c.getDirection();
                    currentPos = newPos;

                    this.visitedPositions.add(currentPos);
                    this.finalPath.add(c.getCommandString());
                    moved = true;
                    break;
                }
            }
            
            // If there are no tiles that we are able to visit then we need to back track
            if (!moved) {
                if(!history.isEmpty()){
                    history.pop();
                    Command previousCommand = history.peek();
                    currentPos = previousCommand.getPosition();
                    currentDir = previousCommand.getDirection();
                    this.finalPath.remove(this.finalPath.size()-1);
                }
            }
        }

    }
    
    public boolean isValid(Position newPosition){
        boolean visited = false;

        //if the row or col of the new position we are trying to go to is not within the bounds of the maze don't go to it
        if (newPosition.getRow() < 0 || newPosition.getRow() >= this.maze.getTotalRow()) return false;
        if (newPosition.getCol() <0 || newPosition.getCol() >= this.maze.getTotalCol()) return false;

        //checks if the new position we want to go to is equal to any of the positions we have visited already
        //if it is true we dont want to go to it because we might loop, so if it is false we want to go to it
        for (Position i: this.visitedPositions){
            if (newPosition.equals(i)){
                visited = true;
                break;
            }
        }

        return this.maze.getTile(newPosition).validPath() && !visited;
    }

    public String getFinalPath(){

        //used to convert the finalPath array list into a String 
        //used an array in the first place to simulate the backtracking capability in the path algorithm
        StringBuilder temp = new StringBuilder();

        for(String i: this.finalPath){
            temp.append(i);
        }
        
        String calculatedPath = temp.toString();

        return calculatedPath;
    }


}
