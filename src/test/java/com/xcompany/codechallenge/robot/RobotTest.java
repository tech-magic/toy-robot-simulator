package com.xcompany.codechallenge.robot;

import com.xcompany.codechallenge.environment.EnvironmentAware;
import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.PlacementParameters;
import com.xcompany.codechallenge.model.Position;
import com.xcompany.codechallenge.resolvers.OrientationResolver;
import com.xcompany.codechallenge.resolvers.PositionResolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by WPerera on 1/18/2018.
 */
public class RobotTest {

    private EnvironmentAware environmentAware;
    private PositionResolver positionResolver;
    private OrientationResolver orientationResolver;

    @Before
    public void setUp() {
        this.environmentAware = mock(EnvironmentAware.class);
        this.positionResolver = mock(PositionResolver.class);
        this.orientationResolver = mock(OrientationResolver.class);
    }

    @Test
    public void testSetup() {
        // Arrange
        Robot robot = new Robot();

        // Act
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);

        // Assert
        assertTrue(robot.isSetupComplete());
    }

    @Test
    public void testValidPlacement() throws Exception {
        // Arrange
        Robot robot = new Robot();
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);
        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        when(this.environmentAware.isSafeToNavigate(position)).thenReturn(true);

        // Act
        robot.place(placementParameters);

        // Assert
        assertTrue(robot.isSetupComplete());
        assertEquals(robot.report().getPosition().getX(), position.getX());
        assertEquals(robot.report().getPosition().getY(), position.getY());
        assertEquals(robot.report().getOrientation(), orientation);
    }

    @Test
    public void testInvalidPlacement1() throws Exception {
        // Arrange
        Robot robot = new Robot();

        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        when(this.environmentAware.isSafeToNavigate(position)).thenReturn(false);
        boolean incompleteSetup = false;

        // Act
        try {
            robot.place(placementParameters);
        } catch (IncompleteSetupException ins) {
            incompleteSetup = true;
        }

        // Assert
        assertFalse(robot.isSetupComplete());
        assertTrue(incompleteSetup);
    }

    @Test
    public void testInvalidPlacement2() throws Exception {
        // Arrange
        Robot robot = new Robot();
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);
        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        when(this.environmentAware.isSafeToNavigate(position)).thenReturn(false);
        boolean invalidPlacement = false;
        boolean placementNotDone = false;

        // Act
        try {
            robot.place(placementParameters);
        } catch (InvalidPlacementException inp) {
            invalidPlacement = true;
        }
        try {
            robot.report();
        } catch (PlacementNotDoneException pnd) {
            placementNotDone = true;
        }

        // Assert
        assertTrue(robot.isSetupComplete());
        assertTrue(invalidPlacement);
        assertTrue(placementNotDone);
    }

    @Test
    public void testSafeMove() throws Exception {
        // Arrange
        Robot robot = new Robot();
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);
        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        int steps = 1;

        when(this.environmentAware.isSafeToNavigate(any(Position.class))).thenReturn(true);
        when(this.positionResolver.moveForward(any(Position.class), any(Orientation.class), any(Integer.class)))
                .thenReturn(new Position(position.getX() + steps, position.getY()));

        robot.place(placementParameters);

        // Act
        robot.move(steps);

        // Assert
        assertTrue(robot.isSetupComplete());
        assertEquals(robot.report().getPosition().getX(), position.getX() + steps);
        assertEquals(robot.report().getPosition().getY(), position.getY());
        assertEquals(robot.report().getOrientation(), orientation);
    }

    @Test
    public void testUnsafeMove() throws Exception {
        // Arrange
        Robot robot = new Robot();
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);
        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        when(this.environmentAware.isSafeToNavigate(any(Position.class))).thenReturn(true);
        robot.place(placementParameters);

        int steps = 1;
        when(this.environmentAware.isSafeToNavigate(any(Position.class))).thenReturn(false);
        when(this.positionResolver.moveForward(any(Position.class), any(Orientation.class), any(Integer.class)))
                .thenReturn(new Position(position.getX() + steps, position.getY()));

        // Act
        robot.move(steps);

        // Assert
        assertTrue(robot.isSetupComplete());
        assertEquals(robot.report().getPosition().getX(), position.getX());
        assertEquals(robot.report().getPosition().getY(), position.getY());
        assertEquals(robot.report().getOrientation(), orientation);
    }

    @Test
    public void testLeft() throws Exception {
        // Arrange
        Robot robot = new Robot();
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);
        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        int steps = 1;

        when(this.orientationResolver.orientAntiClockwise(Orientation.EAST))
                .thenReturn(Orientation.NORTH);
        when(this.environmentAware.isSafeToNavigate(any(Position.class))).thenReturn(true);

        robot.place(placementParameters);

        // Act
        robot.left();

        // Assert
        assertTrue(robot.isSetupComplete());
        assertTrue(robot.isPlacedOnEnvironment());
        assertEquals(robot.report().getOrientation(), Orientation.NORTH);
    }

    @Test
    public void testRight() throws Exception {
        // Arrange
        Robot robot = new Robot();
        robot.setUp(this.environmentAware, this.positionResolver, this.orientationResolver);
        Position position = new Position(3, 4);
        Orientation orientation = Orientation.EAST;
        PlacementParameters placementParameters = new PlacementParameters();
        placementParameters.setPosition(position);
        placementParameters.setOrientation(orientation);
        int steps = 1;

        when(this.orientationResolver.orientClockwise(Orientation.EAST))
                .thenReturn(Orientation.SOUTH);
        when(this.environmentAware.isSafeToNavigate(any(Position.class))).thenReturn(true);

        robot.place(placementParameters);

        // Act
        robot.right();

        // Assert
        assertTrue(robot.isSetupComplete());
        assertTrue(robot.isPlacedOnEnvironment());
        assertEquals(robot.report().getOrientation(), Orientation.SOUTH);
    }
}
