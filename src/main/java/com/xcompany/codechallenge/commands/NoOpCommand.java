package com.xcompany.codechallenge.commands;

import com.xcompany.codechallenge.robot.Robot;

/**
 * Created by WPerera on 1/19/2018.
 */
public class NoOpCommand implements Command {

    public NoOpCommand() {
    }

    public void execute() {
        System.out.println("Unidentified Robot Simulator Command: Refer help for commands or type [ENTER] or [CTRL + C] to exit.");
    }
}
