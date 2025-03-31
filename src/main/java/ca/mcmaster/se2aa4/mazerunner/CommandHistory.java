package ca.mcmaster.se2aa4.mazerunner;
import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command c){
        this.history.push(c);
    }

    public Command pop(){
        return this.history.pop();
    }

    public boolean isEmpty(){
        return this.history.isEmpty();
    }

    public Command peek(){
        return this.history.peek();
    }
}
