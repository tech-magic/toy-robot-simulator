package com.xcompany.codechallenge.inputs;

import com.xcompany.codechallenge.commands.Command;
import com.xcompany.codechallenge.commands.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by WPerera on 1/19/2018.
 */
public abstract class InputReader {

    private BufferedReader bufferedReader;
    private CommandFactory commandFactory;

    public InputReader(InputStream inputStream) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        this.commandFactory = new CommandFactory();
    }

    public void processInput() throws IOException {
        boolean eof = false;
        while(!eof) {
            String nextInputLine = this.getNextInputLine();
            if (nextInputLine != null && nextInputLine.trim().length() > 0) {
                Command nextCommand = this.commandFactory.parseCommand(nextInputLine);
                nextCommand.execute();
            } else {
                eof = true;
            }
        }
    }

    protected String getNextInputLine() throws IOException {
        return this.bufferedReader.readLine();
    }

    @Override
    public void finalize() {
        try {
            this.bufferedReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
