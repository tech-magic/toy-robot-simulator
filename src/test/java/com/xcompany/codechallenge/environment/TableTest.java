package com.xcompany.codechallenge.environment;

import com.xcompany.codechallenge.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by WPerera on 1/17/2018.
 */
public class TableTest {
    @Test
    public void testValidPosition() {
        // Arrange
        int minX = 0, minY = 0, maxX = 5, maxY = 5;
        Table table = new Table(minX, maxX, minY, maxY);
        int x = 3, y = 3;
        Position position = new Position(x, y);

        // Act
        boolean result = table.isWithinSurface(position);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testInvalidPosition1() {
        // Arrange
        int minX = 0, minY = 0, maxX = 5, maxY = 5;
        Table table = new Table(minX, maxX, minY, maxY);
        int x = -2, y = 3;
        Position position = new Position(x, y);

        // Act
        boolean result = table.isWithinSurface(position);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPosition2() {
        // Arrange
        int minX = 0, minY = 0, maxX = 5, maxY = 5;
        Table table = new Table(minX, maxX, minY, maxY);
        int x = 8, y = 3;
        Position position = new Position(x, y);

        // Act
        boolean result = table.isWithinSurface(position);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPosition3() {
        // Arrange
        int minX = 0, minY = 0, maxX = 5, maxY = 5;
        Table table = new Table(minX, maxX, minY, maxY);
        int x = 3, y = -3;
        Position position = new Position(x, y);

        // Act
        boolean result = table.isWithinSurface(position);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPosition4() {
        // Arrange
        int minX = 0, minY = 0, maxX = 5, maxY = 5;
        Table table = new Table(minX, maxX, minY, maxY);
        int x = 3, y = 8;
        Position position = new Position(x, y);

        // Act
        boolean result = table.isWithinSurface(position);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testInvalidPosition5() {
        // Arrange
        int minX = 0, minY = 0, maxX = 5, maxY = 5;
        Table table = new Table(minX, maxX, minY, maxY);
        int x = -2, y = 10;
        Position position = new Position(x, y);

        // Act
        boolean result = table.isWithinSurface(position);

        // Assert
        assertFalse(result);
    }
}
