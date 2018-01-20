# toy-robot-simulator
A modular approach to implement a toy robot simulator.

## Problem

Please find the problem statement for this codechallenge at `src/main/resources/toy_robot_codechallenge.pdf`

## Prerequisites

To build and run this project you need;
1. Java 8
2. Maven 3

## Build Project

1. In command line, navigate to root folder (the folder where the pom.xml)
2. Type `mvn clean install`

## Run Project (in keyboard input mode)

1. In command line, navigate to root folder (the folder where the pom.xml)
2. Type `mvn exec:java`
3. Note that any empty keyboard input (input with no characters other than space) will terminate the program

## Run Project (in file mode)

1. In command line, navigate to root folder (the folder where the pom.xml)
2. Type `mvn exec:java -Dexec.args="src/test/resources/scenario1.txt"`
3. There are 3 sample scenarios in `src/test/resources` folder.
4. Note that any empty line in middle of a file (line with no characters other than space) will terminate the program

