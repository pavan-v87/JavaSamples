package com.learn.atc;

import com.learn.annotation.KpiLogEnd;
import com.learn.annotation.KpiLogStart;

/**
 * Created by Pavan.VijayaNar on 9/3/2017.
 */

public class RunwayImplementation implements Runway {

    @KpiLogStart(category = "land_duration", event = "kpi")
    @KpiLogEnd(category = "land_duration", event = "kpi")
    @Override
    public void land(Plane plane) {

    }

    @Override
    public boolean isFree() {
        return false;
    }
}
