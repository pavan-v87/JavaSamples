package com.learn.sample.file;

import java.io.File;

/**
 * Created by root on 17/12/16.
 */

public interface Folder {

    boolean isValid();
    String getFolderName();
    String[] getAllFileNames();
    String[] getCommonFiles(Folder another);
    void moveFiles(String[] files, Folder destination);
    void moveFile(File file);
}
