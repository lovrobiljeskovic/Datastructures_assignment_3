package com.mycompany.assignment_3_datastructuress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class WordFileReader implements AutoCloseable {

    private BufferedReader reader;

    public WordFileReader(String filePath) throws FileNotFoundException {
        FileReader fr = new FileReader(filePath);
        reader = new BufferedReader(fr);
    }

    public String readAll() throws IOException {
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(stripPunctuation(line));
        }
        return builder.toString();
    }
    
    private String stripPunctuation(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9 ]", "");
    }

    public void close() throws IOException {
        reader.close();
    }
}