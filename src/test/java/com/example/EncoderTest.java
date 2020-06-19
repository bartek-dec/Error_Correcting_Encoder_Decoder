package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EncoderTest {

    byte[] receivedBytes = {84, 101, 115, 116};
    byte[] encodedBytes = {74, -104, -52, 74, 30, -122, 30, -104};
    private Encoder encoder;

    @BeforeEach
    void setUp() {
        encoder = new Encoder(receivedBytes);
    }

    @Test
    void encodedMessageTest() {
        assertArrayEquals(encodedBytes, encoder.encodedMessage());
    }
}