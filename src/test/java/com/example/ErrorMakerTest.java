package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

class ErrorMakerTest {

    @Mock
    private Random random;
    private ErrorMaker errorMaker;
    private byte[] bytes = {74, -104, -52, 74, 30, -122, 30, -104};
    private byte[] bytesWithErrors = {78, -100, -56, 78, 26, -126, 26, -100};

    @BeforeEach
    void setUp() {
        random = Mockito.mock(Random.class);
        errorMaker = new ErrorMaker(random);
        errorMaker.setBytes(bytes);
    }

    @Test
    void getBytesWithErrorsTest() {
        when(random.nextInt(7)).thenReturn(5);
        assertArrayEquals(bytesWithErrors,errorMaker.getBytesWithErrors());
    }
}