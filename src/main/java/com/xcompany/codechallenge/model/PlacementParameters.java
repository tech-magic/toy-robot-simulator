package com.xcompany.codechallenge.model;

import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.Position;

/**
 * Created by WPerera on 1/17/2018.
 */
public class PlacementParameters {

    private Position position;
    private Orientation orientation;


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
