package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteReader {

    private File file;

    public ByteReader(File file) {
        this.file = file;
    }

    public byte[] getBytes() {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            return null;
        }
    }
}
