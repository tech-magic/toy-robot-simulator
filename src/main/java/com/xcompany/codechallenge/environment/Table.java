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
        if (minX > maxX || minY > maxY) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public String toString() {
        return "[ " + this.minX + " <= x <= " + this.maxX + " ] AND [ " +
                this.minY + " <= y <= " + this.maxY + " ]";
    }
}
