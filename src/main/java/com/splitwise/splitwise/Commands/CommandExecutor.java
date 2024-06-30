package com.splitwise.splitwise.Commands;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    List<Command> commands = new ArrayList<Command>();
    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        for (Command command : commands) {
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }

    }
}
