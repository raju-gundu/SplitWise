package com.splitwise.splitwise.Commands;

public interface Command {
    public boolean matches(String input);
    public void execute(String input);

}
