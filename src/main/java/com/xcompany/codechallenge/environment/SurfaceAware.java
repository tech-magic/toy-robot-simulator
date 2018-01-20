package com.xcompany.codechallenge.environment;

import com.xcompany.codechallenge.model.Position;

/**
 * Created by WPerera on 1/17/2018.
 */
public class SurfaceAware implements EnvironmentAware {

    private Surface surface;

    public SurfaceAware(Surface surface) {
        this.surface = surface;
    }

    public boolean isSafeToNavigate(Position position) {
        return this.surface.isWithinSurface(position);
    }
}
