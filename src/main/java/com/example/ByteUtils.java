package com.example;

import java.util.List;

public class ByteUtils {

    public byte[] getBytesArray(List<String>list) {
        byte[] bytes = new byte[list.size()];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) Integer.parseInt(list.get(i), 2);
        }
        return bytes;
    }

    public String createBitSequence(String[] s) {
        StringBuilder builder = new StringBuilder();
        for (String s1 : s) {
            builder.append(s1);
        }
        return builder.toString();
    }

    public int checkP1(String[]s) {
        int value = 0;
        value += s[2].equals("1") ? 1 : 0;
        value += s[4].equals("1") ? 1 : 0;
        value += s[6].equals("1") ? 1 : 0;
        return value;
    }

    public int checkP2(String[]s) {
        int value = 0;
        value += s[2].equals("1") ? 1 : 0;
        value += s[5].equals("1") ? 1 : 0;
        value += s[6].equals("1") ? 1 : 0;
        return value;
    }

    public int checkP4(String[]s) {
        int value = 0;
        value += s[4].equals("1") ? 1 : 0;
        value += s[5].equals("1") ? 1 : 0;
        value += s[6].equals("1") ? 1 : 0;
        return value;
    }
}
