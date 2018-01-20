package com.xcompany.codechallenge.commands;

import com.xcompany.codechallenge.utils.CommonConstants;

/**
 * Created by WPerera on 1/19/2018.
 */
public class CommandFactory {

    public CommandFactory() {
    }

    public Command parseCommand(String command) {
        String upperCommand = command.toUpperCase();

        if (upperCommand.indexOf(CommandTypes.PLACE.name()) != -1) {
            return new PlaceCommand(upperCommand);
        } else if (upperCommand.indexOf(CommandTypes.MOVE.name()) != -1) {
            return new MoveCommand();
        } else if (upperCommand.indexOf(CommandTypes.LEFT.name()) != -1) {
            return new LeftCommand();
        } else if (upperCommand.indexOf(CommandTypes.RIGHT.name()) != -1) {
            return new RightCommand();
        } else if (upperCommand.indexOf(CommandTypes.REPORT.name()) != -1) {
            return new ReportCommand();
        } else {
            return new NoOpCommand();
        }
    }
}
