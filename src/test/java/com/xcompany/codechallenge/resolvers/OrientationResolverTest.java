package com.xcompany.codechallenge.resolvers;

import com.xcompany.codechallenge.model.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by WPerera on 1/17/2018.
 */

public class OrientationResolverTest {

    @Test
    public void testOrientationClockwise1() {
        // Arrange
        Orientation orientation = Orientation.NORTH;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientClockwise(orientation);

        // Assert
        assertEquals(Orientation.EAST, result);
    }

    @Test
    public void testOrientationClockwise2() {
        // Arrange
        Orientation orientation = Orientation.EAST;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientClockwise(orientation);

        // Assert
        assertEquals(Orientation.SOUTH, result);
    }

    @Test
    public void testOrientationClockwise3() {
        // Arrange
        Orientation orientation = Orientation.SOUTH;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientClockwise(orientation);

        // Assert
        assertEquals(Orientation.WEST, result);
    }

    @Test
    public void testOrientationClockwise4() {
        // Arrange
        Orientation orientation = Orientation.WEST;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientClockwise(orientation);

        // Assert
        assertEquals(Orientation.NORTH, result);
    }

    @Test
    public void testOrientationAntiClockwise1() {
        // Arrange
        Orientation orientation = Orientation.NORTH;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientAntiClockwise(orientation);

        // Assert
        assertEquals(Orientation.WEST, result);
    }

    @Test
    public void testOrientationAntiClockwise2() {
        // Arrange
        Orientation orientation = Orientation.WEST;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientAntiClockwise(orientation);

        // Assert
        assertEquals(Orientation.SOUTH, result);
    }

    @Test
    public void testOrientationAntiClockwise3() {
        // Arrange
        Orientation orientation = Orientation.SOUTH;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientAntiClockwise(orientation);

        // Assert
        assertEquals(Orientation.EAST, result);
    }

    @Test
    public void testOrientationAntiClockwise4() {
        // Arrange
        Orientation orientation = Orientation.EAST;
        OrientationResolver orientationResolver = new OrientationResolver();

        // Act
        Orientation result = orientationResolver.orientAntiClockwise(orientation);

        // Assert
        assertEquals(Orientation.NORTH, result);
    }
}
