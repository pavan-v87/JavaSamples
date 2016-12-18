package com.learn.sample.file;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by root on 17/12/16.
 */
public class DiskFolderTest {

    private static final String MOCK_FOLDER_NAME = "docs";

    private final File mockFile1 = new File("File1");
    private final File mockFile2 = new File("File2");
    private final File mockFile3 = new File("File3");
    private final File mockFile4 = new File("File4");

    private final File mockFile5 = new File("File5");
    private final File mockFile6 = new File("File6");

    private final File[] MOCK_FILES = {mockFile1, mockFile2, mockFile3, mockFile4};
    private final String[] MOCK_FILE_NAMES = {mockFile1.getName(), mockFile2.getName(), mockFile3.getName(), mockFile4.getName()};

    @Test
    public void isValid() {

        File mockDiskFolder = Mockito.mock(File.class);

        /* NULL case */
        Folder folder = new DiskFolder(null);
        assertFalse(folder.isValid());

        /* NON-EXIST case */
        folder = new DiskFolder(mockDiskFolder);
        when(mockDiskFolder.exists()).thenReturn(false);
        assertFalse(folder.isValid());

        /* NOT-A-DIRECTORY case*/
        reset(mockDiskFolder);
        when(mockDiskFolder.isDirectory()).thenReturn(false);
        assertFalse(folder.isValid());

        /* Valid  Inputs*/
        constructValidFolderCase(mockDiskFolder);
        assertTrue(folder.isValid());
    }

    private void constructValidFolderCase(File mockDiskFolder) {
        reset(mockDiskFolder);
        when(mockDiskFolder.exists()).thenReturn(true);
        when(mockDiskFolder.isDirectory()).thenReturn(true);
    }


    @Test
    public void getFolderName() {
        File mockDiskFolder = Mockito.mock(File.class);

        /* NULL Inputs */
        Folder folder = new DiskFolder(null);
        assertNull(folder.getFolderName());

        /* Valid  Inputs*/
        constructValidFolderCase(mockDiskFolder);
        when(mockDiskFolder.getName()).thenReturn(MOCK_FOLDER_NAME);

        folder = new DiskFolder(mockDiskFolder);
        String folderName = folder.getFolderName();
        assertEquals(MOCK_FOLDER_NAME, folderName);
    }

    @Test
    public void getAllFiles() {
        File mockDiskFolder = Mockito.mock(File.class);

        { // NULL Inputs
            Folder folder = new DiskFolder(null);
            String[] filesInFolder = folder.getAllFileNames();
            assertNull(filesInFolder);
        }

        { // EMPTY Folder
            constructValidFolderCase(mockDiskFolder);
            when(mockDiskFolder.listFiles()).thenReturn(new File[0]);

            Folder folder = new DiskFolder(mockDiskFolder);
            String[] filesInFolder = folder.getAllFileNames();
            verify(mockDiskFolder).listFiles();
            assertEquals(0, filesInFolder.length);
        }

        { // VALID  Inputs
            constructValidFolderCase(mockDiskFolder);
            when(mockDiskFolder.listFiles()).thenReturn(MOCK_FILES);

            Folder folder = new DiskFolder(mockDiskFolder);
            String[] filesInFolder = folder.getAllFileNames();
            verify(mockDiskFolder).listFiles();

            assertArrayEquals(MOCK_FILE_NAMES, filesInFolder);
        }
    }

    @Test
    public void getCommonFiles() {
        File mockDiskFolder = Mockito.mock(File.class);
        Folder mockedAnotherFolder = Mockito.mock(Folder.class);
        { // NULL Inputs
            Folder folder = new DiskFolder(null);
            String[] filesInFolder = folder.getCommonFiles(mockedAnotherFolder);
            assertNull(filesInFolder);
        }

        {
            constructValidFolderCase(mockDiskFolder);
            when(mockDiskFolder.listFiles()).thenReturn(MOCK_FILES);
            when(mockedAnotherFolder.getAllFileNames()).thenReturn(new String[]{mockFile5.getName()});

            Folder folder = new DiskFolder(mockDiskFolder);
            String[] common = folder.getCommonFiles(mockedAnotherFolder);
            verify(mockedAnotherFolder).getAllFileNames();

            assertArrayEquals(new String[0], common);
        }
    }

}