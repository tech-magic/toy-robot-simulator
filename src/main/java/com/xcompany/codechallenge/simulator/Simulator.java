package com.xcompany.codechallenge.simulator;

import com.xcompany.codechallenge.environment.EnvironmentAware;
import com.xcompany.codechallenge.environment.Surface;
import com.xcompany.codechallenge.environment.SurfaceAware;
import com.xcompany.codechallenge.environment.Table;
import com.xcompany.codechallenge.model.Orientation;
import com.xcompany.codechallenge.model.PlacementParameters;
import com.xcompany.codechallenge.model.Position;
import com.xcompany.codechallenge.resolvers.OrientationResolver;
import com.xcompany.codechallenge.resolvers.PositionResolver;
import com.xcompany.codechallenge.robot.Robot;
import com.xcompany.codechallenge.utils.CommonConstants;

/**
 * Created by WPerera on 1/17/2018.
 */
public class Simulator {

    private static Simulator instance;
    private static Object lock = new Object();

    private Robot robot;
    private Surface surface;

    private Simulator() {
        this.setUp();
    }

    public static Simulator getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new Simulator();
            }
        }
        return instance;
    }

    public void setUp() {
        try {
            // Environment
            this.surface = new Table(
                    CommonConstants.SURFACE_MIN_X,
                    CommonConstants.SURFACE_MAX_X,
                    CommonConstants.SURFACE_MIN_Y,
                    CommonConstants.SURFACE_MAX_Y
            );
            EnvironmentAware environmentAware = new SurfaceAware(surface);

            // Resolvers
            PositionResolver positionResolver = new PositionResolver();
            OrientationResolver orientationResolver = new OrientationResolver();

            // Robot
            this.robot = new Robot();
            robot.setUp(environmentAware, positionResolver, orientationResolver);
        } catch (IllegalArgumentException iarex) {
            System.out.println("Unable to setup simulator. Please check surface configurations at CommonConstants.");
        }
    }

    public Robot getRobot() {
        return this.robot;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
