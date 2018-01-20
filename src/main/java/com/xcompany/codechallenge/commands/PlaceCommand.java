package com.xcompany.codechallenge.commands;

import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.PlacementParameters;
import com.xcompany.codechallenge.model.Position;
import com.xcompany.codechallenge.robot.IncompleteSetupException;
import com.xcompany.codechallenge.robot.InvalidPlacementException;
import com.xcompany.codechallenge.simulator.Simulator;
import com.xcompany.codechallenge.utils.CommonConstants;

import java.util.StringTokenizer;

/**
 * Created by WPerera on 1/19/2018.
 */
public class PlaceCommand implements Command {

    private String command;

    public PlaceCommand(String command) {
        this.command = command;
    }

    public void execute() {
        try {
            PlacementParameters placementParameters = this.fetchPlacementParameters(this.command);
            Simulator.getInstance().getRobot().place(placementParameters);
        } catch (IncompleteSetupException ins) {
            System.out.println("Robot Setup is Incomplete!");
        } catch (InvalidPlacementException invpl) {
            System.out.println("Unable to place Robot on the surface!");
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid PLACE command. Couldn't place robot! > " + this.command);
        } catch (IllegalArgumentException iaex) {
            System.out.println("Invalid PLACE command. Couldn't place robot! > " + this.command);
        }
    }

    private PlacementParameters fetchPlacementParameters(String command) {
        StringTokenizer tokens = new StringTokenizer(
                command.substring(command.indexOf(CommonConstants.SPACE), command.length()), CommonConstants.COMMA);
        int x = CommonConstants.SURFACE_MIN_X - 1, y = CommonConstants.SURFACE_MIN_Y - 1;
        Orientation orientation = null;
        int index = 0;
        while (tokens.hasMoreTokens()) {
            String nextToken = tokens.nextToken().trim();
            if (index == 0) {
                x = Integer.parseInt(nextToken);
            } else if (index == 1) {
                y = Integer.parseInt(nextToken);
            } else if (index == 2) {
                orientation = Orientation.valueOf(nextToken.toUpperCase());
            }
            index++;
        }

        if (x < CommonConstants.SURFACE_MIN_X || y < CommonConstants.SURFACE_MIN_Y) {
            throw new IllegalArgumentException();
        }
        if (orientation == null) {
            throw new IllegalArgumentException();
        }

        Position position = new Position(x, y);
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        return placementParameters;
    }
}
