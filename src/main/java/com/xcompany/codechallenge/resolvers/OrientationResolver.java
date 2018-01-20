package com.xcompany.codechallenge.resolvers;

import com.xcompany.codechallenge.model.Orientation;

/**
 * Created by WPerera on 1/16/2018.
 */
public class OrientationResolver {

    public OrientationResolver() {
    }

    public Orientation orientAntiClockwise(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return Orientation.WEST;
            case EAST:
                return Orientation.NORTH;
            case SOUTH:
                return Orientation.EAST;
            default:
                return Orientation.SOUTH;
        }
    }

    public Orientation orientClockwise(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return Orientation.EAST;
            case WEST:
                return Orientation.NORTH;
            case SOUTH:
                return Orientation.WEST;
            default:
                return Orientation.SOUTH;
        }
    }
}
