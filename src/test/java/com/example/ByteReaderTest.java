package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ByteReaderTest {

    private File file;
    private ByteReader reader;

    @BeforeEach
    void setUp() throws IOException {
        file = new File("./src/test/java/resources/input.txt");
        reader = new ByteReader(file);
    }

    @Test
    void getBytesWhenRead_Test_Then4BytesExpected() {
        byte[] expected = {84, 101, 115, 116};
        assertArrayEquals(expected, reader.getBytes());
    }

    @Test
    void getBytesWhenFileNotFoundThenNullArray() {
        reader = new ByteReader(new File("./src/test/java/resources/someFile.txt"));
        assertNull(reader.getBytes());
    }
}