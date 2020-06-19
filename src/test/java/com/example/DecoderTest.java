package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DecoderTest {

    byte[] encodedBytes = {90, -120, -116, 78, 22, -90, 62, -112};
    byte[] decodedBytes = {84, 101, 115, 116};
    private Decoder decoder;

    @BeforeEach
    void setUp() {
        decoder = new Decoder(encodedBytes);
    }

    @Test
    void decodeMessageTest() {
        assertArrayEquals(decodedBytes, decoder.decodeMessage());
    }
}