package com.xcompany.codechallenge.environment;

import com.xcompany.codechallenge.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by WPerera on 1/18/2018.
 */
public class SurfaceAwareTest {
    @Test
    public void testSafePosition() {
        // Arrange
        Position position = new Position(3, 3);
        Table table = mock(Table.class);
        when(table.isWithinSurface(position)).thenReturn(true);
        SurfaceAware surfaceAware = new SurfaceAware(table);

        // Act
        boolean result = surfaceAware.isSafeToNavigate(position);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testUnsafePosition() {
        // Arrange
        Position position = new Position(-3, 3);
        Table table = mock(Table.class);
        when(table.isWithinSurface(position)).thenReturn(false);
        SurfaceAware surfaceAware = new SurfaceAware(table);

        // Act
        boolean result = surfaceAware.isSafeToNavigate(position);

        // Assert
        assertFalse(result);
    }
}
