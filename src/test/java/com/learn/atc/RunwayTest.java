package com.learn.atc;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Pavan.VijayaNar on 9/3/2017.
 */

//@RunWith(MockitoJUnitRunner.class)
public class RunwayTest {

    //@Mock
    private Plane plane;

    @Test
    public void testLand() {

        Runway runway = new RunwayImplementation();
        runway.land(plane);

    }

}