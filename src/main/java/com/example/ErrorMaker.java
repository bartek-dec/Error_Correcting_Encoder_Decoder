package com.example;

import java.util.Random;

public class ErrorMaker {

    private Random random;
    private byte[] bytes;
    private byte[] bytesWithErrors;

    public ErrorMaker(Random random) {
        this.random = random;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytesWithErrors() {
        int length = bytes.length;
        bytesWithErrors = new byte[length];
        for (int i = 0; i < length; i++) {
            String[] s = (String.format("%8s", Integer.toBinaryString(Byte.toUnsignedInt(bytes[i])))
                    .replace(' ', '0')).split("");
            int randomIndex = random.nextInt(7);
            String bit = s[randomIndex];
            s[randomIndex] = bit.equals("1") ? "0" : "1";
            bytesWithErrors[i] = (byte) Integer.parseInt(convertToByteRepresentation(s), 2);
        }
        return bytesWithErrors;
    }

    private String convertToByteRepresentation(String[] s) {
        StringBuilder builder = new StringBuilder();
        for (String s1 : s) {
            builder.append(s1);
        }
        return builder.toString();
    }
}
