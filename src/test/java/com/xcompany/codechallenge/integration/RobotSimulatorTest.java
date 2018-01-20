package com.xcompany.codechallenge.integration;

import com.xcompany.codechallenge.inputs.DiskFileInputReader;
import com.xcompany.codechallenge.inputs.InputReader;
import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.simulator.Simulator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

/**
 * Created by WPerera on 1/21/2018.
 */
@Category(IntegrationTest.class)
public class RobotSimulatorTest {
    @Test
    public void scenario1() throws Exception {
        Simulator simulator = Simulator.getInstance();
        simulator.setUp();
        InputReader inputReader = new DiskFileInputReader("src/test/resources/scenario1.txt");
        inputReader.processInput();

        assertEquals(0, simulator.getRobot().report().getPosition().getX(), 0);
        assertEquals(1, simulator.getRobot().report().getPosition().getY(), 1);
        assertEquals(Orientation.NORTH, simulator.getRobot().report().getOrientation());
    }

    @Test
    public void scenario2() throws Exception {
        Simulator simulator = Simulator.getInstance();
        simulator.setUp();
        InputReader inputReader = new DiskFileInputReader("src/test/resources/scenario2.txt");
        inputReader.processInput();

        assertEquals(0, simulator.getRobot().report().getPosition().getX());
        assertEquals(0, simulator.getRobot().report().getPosition().getY());
        assertEquals(Orientation.WEST, simulator.getRobot().report().getOrientation());
    }

    @Test
    public void scenario3() throws Exception {
        Simulator simulator = Simulator.getInstance();
        simulator.setUp();
        InputReader inputReader = new DiskFileInputReader("src/test/resources/scenario3.txt");
        inputReader.processInput();

        assertEquals(3, simulator.getRobot().report().getPosition().getX());
        assertEquals(3, simulator.getRobot().report().getPosition().getY());
        assertEquals(Orientation.NORTH, simulator.getRobot().report().getOrientation());
    }
}
