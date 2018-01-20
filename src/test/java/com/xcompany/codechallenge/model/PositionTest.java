package com.xcompany.codechallenge.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by WPerera on 1/19/2018.
 */
public class PositionTest {
    @Test
    public void testPositionConstructor() {
        // Arrange
        int x = 6;
        int y = 3;

        // Act
        Position position = new Position(x, y);

        // Assert
        assertEquals(position.getX(), x);
        assertEquals(position.getY(), y);
    }

    @Test
    public void testPositionAccessors() {
        // Arrange
        int x = 6;
        int y = 3;
        int newX = 8;
        int newY = 2;

        // Act
        Position position = new Position(x, y);
        position.setX(newX);
        position.setY(newY);

        // Assert
        assertFalse(position.getX() == x);
        assertFalse(position.getY() == y);
        assertEquals(position.getX(), newX);
        assertEquals(position.getY(), newY);
    }
}
