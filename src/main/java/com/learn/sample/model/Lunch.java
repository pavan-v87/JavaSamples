package com.learn.sample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by Pavan.VijayaNar on 5/31/2017.
 */

public class Lunch {
    private List<String> menu = new ArrayList<>();
    Semaphore semaphore = new Semaphore(1);

    public void eat() {
        menu.remove(0);
    }
    public void serve(String item) {
        menu.add(item);
    }
}
