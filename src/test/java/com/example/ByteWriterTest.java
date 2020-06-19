package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteWriterTest {

    private File file;
    private ByteWriter writer;

    @BeforeEach
    void setUp() throws IOException {
        file = File.createTempFile("fileTest", "tmp");
        writer = new ByteWriter(file);
        file.deleteOnExit();
    }

    @AfterEach
    public void cleanUp() {
        file.delete();
    }

    @Test
    void saveMessage() throws IOException {
        byte[] arrayToWrite = {84, 101, 115, 116};
        writer.saveMessage(arrayToWrite);

        assertEquals("Test", new String(Files.readAllBytes(file.toPath())));
    }
}