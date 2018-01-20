package com.xcompany.codechallenge.commands;

import com.xcompany.codechallenge.robot.IncompleteSetupException;
import com.xcompany.codechallenge.robot.PlacementNotDoneException;
import com.xcompany.codechallenge.simulator.Simulator;

/**
 * Created by WPerera on 1/19/2018.
 */
public class RightCommand implements Command {

    public RightCommand() {
    }

    public void execute() {
        try {
            Simulator.getInstance().getRobot().right();
        } catch (IncompleteSetupException ics) {
            System.out.println("Robot Setup is Incomplete!");
        } catch (PlacementNotDoneException pnd) {
            System.out.println("Robot is not placed on the surface yet!");
        }
    }
}
