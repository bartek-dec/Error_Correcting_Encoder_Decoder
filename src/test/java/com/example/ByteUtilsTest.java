package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteUtilsTest {

    private String[] bits = {"1", "0", "0", "1", "1", "0", "0", "0"};
    private List<String> list = new ArrayList<>();
    private ByteUtils byteUtils;

    @BeforeEach
    void setUp() {
        list.add("10011000");
        list.add("10000110");
        byteUtils = new ByteUtils();
    }

    @Test
    void testCheckP1() {
        assertEquals(1, byteUtils.checkP1(bits));
    }

    @Test
    void testCheckP2() {
        assertEquals(0, byteUtils.checkP2(bits));
    }

    @Test
    void testCheckP4() {
        assertEquals(1, byteUtils.checkP4(bits));
    }

    @Test
    void createBitSequence() {
        assertEquals("10011000", byteUtils.createBitSequence(bits));
    }

    @Test
    void getBytesArrayWhenTwoStringsThenTwoBytes() {
        byte[] expected = {-104, -122};
        assertArrayEquals(expected, byteUtils.getBytesArray(list));
    }

    @Test
    void getBytesArrayWhenEmptyListThenTwoBytes() {
        assertEquals(0, byteUtils.getBytesArray(new ArrayList<>()).length);
    }
}