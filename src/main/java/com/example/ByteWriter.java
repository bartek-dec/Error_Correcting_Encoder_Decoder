package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriter {

    private File file;

    public ByteWriter(File file) {
        this.file = file;
    }

    public void saveMessage(byte[] message) {
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
