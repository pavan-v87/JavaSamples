package com.learn.atc;

/**
 * Created by Pavan.VijayaNar on 9/3/2017.
 */

public interface Plane {
    void getName();
    void land(Runway runway);
    Properties getProperties();
    interface Properties {
        int fuelLevel();
    }
}
