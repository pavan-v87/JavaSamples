package com.learn.atc;

/**
 * Created by Pavan.VijayaNar on 9/3/2017.
 */

public interface Runway {
    void land(Plane plane);
    boolean isFree();
}
