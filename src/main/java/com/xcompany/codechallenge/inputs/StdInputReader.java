package com.xcompany.codechallenge.inputs;

import java.io.IOException;

/**
 * Created by WPerera on 1/19/2018.
 */
public class StdInputReader extends InputReader {
    public StdInputReader() {
        super(System.in);
        this.printHelp();
    }

    @Override
    protected String getNextInputLine() throws IOException {
        System.out.println("simulator prompt >");
        return super.getNextInputLine();
    }

    private void printHelp() {
        System.out.println("Keyboard Input Help");
        System.out.println("===================");
        System.out.println("supported commands: place x, y, orientation");
        System.out.println("1. place x, y, orientation (e.g. place 3, 3, NORTH)");
        System.out.println("2. move");
        System.out.println("3. left");
        System.out.println("4. right");
        System.out.println("5. report");
        System.out.println("Press [ENTER] without any prompt to exit.");
        System.out.println();
    }
}
