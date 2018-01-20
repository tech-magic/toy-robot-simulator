package com.xcompany.codechallenge.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by WPerera on 1/19/2018.
 */
public class PlacementParametersTest {
    @Test
    public void testAccessors() {
        // Arrange
        int x = 6, y = 7;
        Orientation orientation = Orientation.SOUTH;
        Position position = new Position(x, y);

        // Act
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);

        // Assert
        assertEquals(placementParameters.getPosition().getX(), x);
        assertEquals(placementParameters.getPosition().getY(), y);
        assertEquals(placementParameters.getOrientation(), orientation);
    }
}
