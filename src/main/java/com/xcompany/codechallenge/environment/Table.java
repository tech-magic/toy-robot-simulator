package com.xcompany.codechallenge.environment;

import com.xcompany.codechallenge.model.Position;

/**
 * Created by WPerera on 1/17/2018.
 */
public class Table implements Surface {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Table(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isWithinSurface(Position position) {
        return (position.getX() >= this.minX &&
                position.getX() <= this.maxX &&
                position.getY() >= this.minY &&
                position.getY() <= this.maxY);
    }
}
