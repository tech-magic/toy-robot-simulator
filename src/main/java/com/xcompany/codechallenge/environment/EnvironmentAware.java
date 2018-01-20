package com.xcompany.codechallenge.environment;

import com.xcompany.codechallenge.model.Position;

/**
 * Created by WPerera on 1/17/2018.
 */
public interface EnvironmentAware {
    boolean isSafeToNavigate(Position position);
}
