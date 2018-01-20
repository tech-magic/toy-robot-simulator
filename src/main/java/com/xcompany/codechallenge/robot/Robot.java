package com.xcompany.codechallenge.robot;

import com.xcompany.codechallenge.environment.EnvironmentAware;
import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.resolvers.OrientationResolver;
import com.xcompany.codechallenge.resolvers.PositionResolver;
import com.xcompany.codechallenge.model.PlacementParameters;
import com.xcompany.codechallenge.model.Position;

/**
 * Created by WPerera on 1/16/2018.
 */
public class Robot {

    private Position position;
    private Orientation orientation;

    private PositionResolver positionResolver;
    private OrientationResolver orientationResolver;
    private EnvironmentAware environmentAware;

    private boolean isPlacedOnEnvironment = false;
    private boolean isSetupComplete = false;

    public Robot() {
    }

    public void setUp(EnvironmentAware environmentAware,
                      PositionResolver positionResolver,
                      OrientationResolver orientationResolver) {
        this.environmentAware = environmentAware;
        this.positionResolver = positionResolver;
        this.orientationResolver = orientationResolver;
        this.isSetupComplete = true;
    }

    public boolean isSetupComplete() {
        return this.isSetupComplete;
    }

    public boolean isPlacedOnEnvironment() {
        return this.isPlacedOnEnvironment;
    }

    public void place(PlacementParameters placementParameters)
            throws IncompleteSetupException, InvalidPlacementException {
        this.checkSetup();
        Position proposedPosition = placementParameters.getPosition();
        if (this.environmentAware.isSafeToNavigate(proposedPosition)) {
            this.position = proposedPosition;
            this.orientation = placementParameters.getOrientation();
            this.isPlacedOnEnvironment = true;
        } else {
            throw new InvalidPlacementException();
        }
    }

    public void move(int steps) throws IncompleteSetupException, PlacementNotDoneException {
        this.checkSetup();
        this.checkPlacement();
        Position proposedPosition =
                this.positionResolver.moveForward(this.position, this.orientation, steps);
        if (this.environmentAware.isSafeToNavigate(proposedPosition)) {
            this.position = proposedPosition;
        }
    }

    public void left() throws IncompleteSetupException, PlacementNotDoneException {
        this.checkSetup();
        this.checkPlacement();
        this.orientation = this.orientationResolver.orientAntiClockwise(this.orientation);
    }

    public void right() throws IncompleteSetupException, PlacementNotDoneException {
        this.checkSetup();
        this.checkPlacement();
        this.orientation = this.orientationResolver.orientClockwise(this.orientation);
    }

    public PlacementParameters report()
            throws IncompleteSetupException, PlacementNotDoneException {
        this.checkSetup();
        this.checkPlacement();
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(this.position);
        placementParameters.setOrientation(this.orientation);
        return placementParameters;
    }

    private void checkSetup() throws IncompleteSetupException {
        if (!this.isSetupComplete()) {
            throw new IncompleteSetupException();
        }
    }

    private void checkPlacement() throws PlacementNotDoneException {
        if (!this.isPlacedOnEnvironment()) {
            throw new PlacementNotDoneException();
        }
    }
}
