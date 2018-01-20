package com.xcompany.codechallenge.commands;

import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.PlacementParameters;
import com.xcompany.codechallenge.model.Position;
import com.xcompany.codechallenge.robot.IncompleteSetupException;
import com.xcompany.codechallenge.robot.PlacementNotDoneException;
import com.xcompany.codechallenge.simulator.Simulator;

/**
 * Created by WPerera on 1/19/2018.
 */
public class ReportCommand implements Command {

    public ReportCommand() {
    }

    public void execute() {
        try {
            PlacementParameters placementParameters = Simulator.getInstance().getRobot().report();
            Position currPosition = placementParameters.getPosition();
            Orientation orientation = placementParameters.getOrientation();
            System.out.println("Output: " + currPosition.getX() + "," + currPosition.getY() + ", " + orientation.name());
        } catch (IncompleteSetupException ics) {
            System.out.println("Robot Setup is Incomplete!");
        } catch (PlacementNotDoneException pnd) {
            System.out.println("Robot is not placed on the surface yet!");
        }
    }
}
