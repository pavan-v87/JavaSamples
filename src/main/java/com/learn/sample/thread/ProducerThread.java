package com.learn.sample.thread;

import java.util.List;

/**
 * Created by Pavan.VijayaNar on 5/31/2017.
 */

public class ProducerThread extends Thread {

    private final List<String> mList;

    public ProducerThread(List<String> stringList) {
        mList = stringList;
    }

    @Override
    public void run() {
        super.run();
    }
}
