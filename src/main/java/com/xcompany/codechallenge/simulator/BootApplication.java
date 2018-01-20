package com.xcompany.codechallenge.simulator;

import com.xcompany.codechallenge.inputs.DiskFileInputReader;
import com.xcompany.codechallenge.inputs.InputReader;
import com.xcompany.codechallenge.inputs.StdInputReader;

import java.io.File;

/**
 * Created by WPerera on 1/19/2018.
 */
public class BootApplication {

    public static void main(String args[]) throws Exception {

        String inputFileName = null;
        if (args.length == 1) {
            try {
                String proposedInputFileName = args[0];
                File inputFile = new File(proposedInputFileName);
                if (inputFile.exists()) {
                    inputFileName = proposedInputFileName;
                } else {
                    System.out.println("Proposed input file " + proposedInputFileName + " doesn't exist. Rolling back to keyboard input mode.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        Simulator simulator = Simulator.getInstance();
        simulator.setUp();

        InputReader inputReader = null;
        if (inputFileName != null) {
            inputReader = new DiskFileInputReader(inputFileName);
        } else {
            inputReader = new StdInputReader();
        }
        inputReader.processInput();
    }
}
