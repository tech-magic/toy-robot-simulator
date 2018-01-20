package com.xcompany.codechallenge.commands;

import com.xcompany.codechallenge.robot.IncompleteSetupException;
import com.xcompany.codechallenge.robot.PlacementNotDoneException;
import com.xcompany.codechallenge.simulator.Simulator;

import com.xcompany.codechallenge.utils.CommonConstants;

/**
 * Created by WPerera on 1/19/2018.
 */
public class MoveCommand implements Command {

    public MoveCommand() {
    }

    public void execute() {
        try {
            Simulator.getInstance().getRobot().move(CommonConstants.DEFAULT_STEPS);
        } catch (IncompleteSetupException ics) {
            System.out.println("Robot Setup is Incomplete!");
        } catch (PlacementNotDoneException pnd) {
            System.out.println("Robot is not placed on the surface yet!");
        }
    }
}
