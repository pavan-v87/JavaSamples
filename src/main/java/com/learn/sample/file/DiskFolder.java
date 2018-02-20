package com.learn.sample.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17/12/16.
 */

public class DiskFolder implements Folder {

    //private File[] mContentFiles;

    private final File mFile;

    public DiskFolder(File file) {
        mFile = file;
    }

    @Override
    public boolean isValid() {
        boolean valid = false;
        if (mFile !=null && mFile.exists() && mFile.isDirectory()) {
            valid = true;
        }
        return valid;
    }

    @Override
    public String getFolderName() {
        String name = null;
        if (isValid()) {
            name = mFile.getName();
        }
        return name;
    }

    @Override
    public String[] getAllFileNames() {
        String[] fileNames = null;
        if (isValid()) {
            File[] files = mFile.listFiles();
            fileNames = new String[files.length];
            for (int i=0; i<files.length; i++) {
                fileNames[i] = files[i].getName();
            }
        }
        return fileNames;
    }

    @Override
    public String[] getCommonFiles(Folder another) { // Intersection of 2 arrays
        String[] common = null;
        if (isValid()) {
            List<String> temp = new ArrayList<>();
            String[] filesInThisFolder = getAllFileNames();
            String[] filesInAnotherFolder = another.getAllFileNames();
            for (String fi : filesInThisFolder) {
                for (String fa: filesInAnotherFolder) {
                    if (fi.contentEquals(fa)) {
                        temp.add(fa);
                    }
                }
            }
            common = temp.toArray(new String[0]);
        }
        return common;
    }

    @Override
    public void moveFiles(String[] files, Folder destination) {
        File[] filesInThisFolder = mFile.listFiles();
        for (String fi : files) {
            for (File file : filesInThisFolder) {
                if (file.getName().contentEquals(fi)) {
                    destination.moveFile(file);
                    //file.delete();
                }
            }
        }
    }

    @Override
    public void moveFile(File file) {
        String incomingFileName = file.getName();
        String newFilePath = mFile.getAbsolutePath() + "/" + incomingFileName;
        file.renameTo(new File(newFilePath));
    }
}
