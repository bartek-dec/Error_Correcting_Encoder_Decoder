package com.example;

import java.util.ArrayList;
import java.util.List;

public class Encoder {

    private byte[] bytes;
    private List<String> bytesWithParity = new ArrayList<>();
    private ByteUtils byteUtils;

    public Encoder(byte[] bytes) {
        this.bytes = bytes;
        byteUtils = new ByteUtils();
    }

    public byte[] encodedMessage() {
        String[] bits = getBitSequence().split("");

        int length = bits.length;
        for (int i = 0; i < length; i += 4) {
            String[] seq = new String[8];
            seq[2] = bits[i];
            seq[4] = bits[i + 1];
            seq[5] = bits[i + 2];
            seq[6] = bits[i + 3];
            seq[7] = "0";

            seq = checkP1(seq);
            seq = checkP2(seq);
            seq = checkP4(seq);

            bytesWithParity.add(byteUtils.createBitSequence(seq));
        }
        return byteUtils.getBytesArray(bytesWithParity);
    }

    private String[] checkP1(String[] s) {
        int value = byteUtils.checkP1(s);

        if (value % 2 == 0) {
            s[0] = "0";
        } else {
            s[0] = "1";
        }
        return s;
    }

    private String[] checkP2(String[] s) {
        int value = byteUtils.checkP2(s);

        if (value % 2 == 0) {
            s[1] = "0";
        } else {
            s[1] = "1";
        }
        return s;
    }

    private String[] checkP4(String[] s) {
        int value = byteUtils.checkP4(s);

        if (value % 2 == 0) {
            s[3] = "0";
        } else {
            s[3] = "1";
        }
        return s;
    }

    private String getBitSequence() {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%8s", Integer.toBinaryString(Byte.toUnsignedInt(b))).replace(' ', '0'));
        }
        return builder.toString();
    }
}
