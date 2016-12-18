package com.learn.sample.thread;

import com.learn.sample.file.DiskFolder;
import com.learn.sample.file.Folder;

import java.io.File;

/**
 * Created by root on 18/12/16.
 */

public class MyThread extends Thread{

    private boolean stop = false;

    private Folder docsFolder = new DiskFolder(new File("/home/pavan/Desktop/Thread/docs"));
    private Folder ctrlFolder = new DiskFolder(new File("/home/pavan/Desktop/Thread/ctrl"));
    private Folder archFolder = new DiskFolder(new File("/home/pavan/Desktop/Thread/arch"));

    @Override
    public void run() {

        String[] commonFiles = docsFolder.getCommonFiles(ctrlFolder);
        ctrlFolder.moveFiles(commonFiles, archFolder);
    }
}
