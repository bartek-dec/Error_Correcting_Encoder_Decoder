package com.example;

import java.util.ArrayList;
import java.util.List;

public class Decoder {

    private byte[] bytes;
    private List<String> decodedBytes = new ArrayList<>();
    private ByteUtils byteUtils;

    public Decoder(byte[] bytes) {
        this.bytes = bytes;
        byteUtils = new ByteUtils();
    }

    public byte[] decodeMessage() {
        StringBuilder builder = new StringBuilder();

        for (byte b : bytes) {
            String[] s = (String.format("%8s", Integer.toBinaryString(Byte.toUnsignedInt(b)))
                    .replace(' ', '0')).split("");

            boolean p1 = checkP1(s);
            boolean p2 = checkP2(s);
            boolean p4 = checkP4(s);

            if (!p1 && !p2 && !p4) {
                s[6] = s[6].equals("1") ? "0" : "1";
            } else if (!p1 && !p2) {
                s[2] = s[2].equals("1") ? "0" : "1";
            } else if (!p1 && !p4) {
                s[4] = s[4].equals("1") ? "0" : "1";
            } else if (!p2 && !p4) {
                s[5] = s[5].equals("1") ? "0" : "1";
            }

            builder.append(s[2]).append(s[4]).append(s[5]).append(s[6]);
        }
        splitBitSequence(builder.toString());
        return byteUtils.getBytesArray(decodedBytes);
    }

    private void splitBitSequence(String s) {
        int bytes = s.length() / 8;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes * 8; i += 8) {
            builder.append(s.charAt(i)).append(s.charAt(i + 1)).append(s.charAt(i + 2)).append(s.charAt(i + 3))
                    .append(s.charAt(i + 4)).append(s.charAt(i + 5)).append(s.charAt(i + 6)).append(s.charAt(i + 7));
            decodedBytes.add(builder.toString());
            builder.setLength(0);
        }
    }

    private boolean checkP1(String[] s) {
        int p1 = Integer.parseInt(s[0]);
        int value = byteUtils.checkP1(s);

        if (value % 2 == 0 && p1 == 0) {
            return true;
        } else if (value % 2 == 1 && p1 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkP2(String[] s) {
        int p2 = Integer.parseInt(s[1]);
        int value = byteUtils.checkP2(s);

        if (value % 2 == 0 && p2 == 0) {
            return true;
        } else if (value % 2 == 1 && p2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkP4(String[] s) {
        int p4 = Integer.parseInt(s[3]);
        int value = byteUtils.checkP4(s);

        if (value % 2 == 0 && p4 == 0) {
            return true;
        } else if (value % 2 == 1 && p4 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
