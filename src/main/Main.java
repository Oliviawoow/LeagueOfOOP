package main;

import heroes.Round;

import java.io.FileNotFoundException;
import java.io.IOException;
import fileio.implementations.FileReader;
import fileio.implementations.FileWriter;


public class Main {
    private Main() {

    }

    public static void main(final String[] args) throws IOException {
        final Round round = new Round();
        String fileIn = args[0];
        String fileOut = args[1];

        /*citire din fisier*/
        try {
            FileReader read = new FileReader(fileIn);
            int n = read.nextInt();
            int m = read.nextInt();
        }
    }
}
