package com.xcompany.codechallenge.resolvers;

import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by WPerera on 1/17/2018.
 */
public class PositionResolverTest {
    @Test
    public void testMovementToNorth() {
        // Arrange
        int x = 2;
        int y = 2;
        Orientation orientation = Orientation.NORTH;
        int steps = 2;

        Position position = new Position(x, y);
        PositionResolver positionResolver = new PositionResolver();

        // Act
        Position resultsPosition = positionResolver.moveForward(position, orientation, steps);

        // Assert
        assertEquals(x, resultsPosition.getX());
        assertEquals(y + steps, resultsPosition.getY());
    }

    @Test
    public void testMovementToEast() {
        // Arrange
        int x = 2;
        int y = 2;
        Orientation orientation = Orientation.EAST;
        int steps = 2;

        Position position = new Position(x, y);
        PositionResolver positionResolver = new PositionResolver();

        // Act
        Position resultsPosition = positionResolver.moveForward(position, orientation, steps);

        // Assert
        assertEquals(x + steps, resultsPosition.getX());
        assertEquals(y, resultsPosition.getY());
    }

    @Test
    public void testMovementToSouth() {
        // Arrange
        int x = 2;
        int y = 2;
        Orientation orientation = Orientation.SOUTH;
        int steps = 2;

        Position position = new Position(x, y);
        PositionResolver positionResolver = new PositionResolver();

        // Act
        Position resultsPosition = positionResolver.moveForward(position, orientation, steps);

        // Assert
        assertEquals(x, resultsPosition.getX());
        assertEquals(y - steps, resultsPosition.getY());
    }

    @Test
    public void testMovementToWest() {
        // Arrange
        int x = 2;
        int y = 2;
        Orientation orientation = Orientation.WEST;
        int steps = 2;

        Position position = new Position(x, y);
        PositionResolver positionResolver = new PositionResolver();

        // Act
        Position resultsPosition = positionResolver.moveForward(position, orientation, steps);

        // Assert
        assertEquals(x - steps, resultsPosition.getX());
        assertEquals(y, resultsPosition.getY());
    }
}
