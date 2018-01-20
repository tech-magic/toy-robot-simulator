package com.xcompany.codechallenge.resolvers;

import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.Position;

/**
 * Created by WPerera on 1/16/2018.
 */
public class PositionResolver {

    public PositionResolver() {
    }

    public Position moveForward(Position position, Orientation orientation, int steps) {
        switch (orientation) {
            case NORTH:
                return new Position(position.getX(), position.getY() + steps);
            case EAST:
                return new Position(position.getX() + steps, position.getY());
            case WEST:
                return new Position(position.getX() - steps, position.getY());
            default:
                return new Position(position.getX(), position.getY() - steps);
        }
    }
}
