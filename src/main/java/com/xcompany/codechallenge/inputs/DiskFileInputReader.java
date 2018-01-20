package com.xcompany.codechallenge.inputs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by WPerera on 1/19/2018.
 */
public class DiskFileInputReader extends InputReader {
    public DiskFileInputReader(String fileName) throws FileNotFoundException {
        super(new FileInputStream(fileName));
    }
}
