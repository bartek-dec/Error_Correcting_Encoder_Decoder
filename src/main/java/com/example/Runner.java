package com.example;

import java.io.File;
import java.util.Random;

public class Runner {

    private final String path = "./src/main/resources/";
    private File send;
    private File encoded;
    private File decoded;
    private File received;
    private ByteReader byteReader;
    private ErrorMaker errorMaker;
    private ByteWriter writer;
    private Random random;
    private Encoder encoder;
    private Decoder decoder;

    public Runner() {
    }

    public void run(String mode) {

        switch (mode) {
            case "encode":
                performEncode();
                break;
            case "send":
                performSend();
                break;
            case "decode":
                performDecode();
                break;
            default:
                System.out.println("Please write correct mode.");
        }
    }

    private void performEncode() {
        send = new File(path + "send.txt");
        encoded = new File(path + "encoded.txt");

        byte[] bytes = readFile(send);

        if (bytes != null) {
            byte[] encodedBytes = encodeBytes(bytes);
            writeToFile(encoded, encodedBytes);
        } else {
            System.out.println("File: " + send.getName() + " does not exist.");
        }
    }

    private void performSend() {
        encoded = new File(path + "encoded.txt");
        received = new File(path + "received.txt");

        byte[] bytes = readFile(encoded);
        if (bytes != null) {
            byte[] bytesWithErrors = provideErrors(bytes);
            writeToFile(received, bytesWithErrors);
        } else {
            System.out.println("File: " + encoded.getName() + " does not exist.");
        }
    }

    private void performDecode() {
        received = new File(path + "received.txt");
        decoded = new File(path + "decoded.txt");

        byte[] bytes = readFile(received);
        if (bytes != null) {
            byte[] decodedBytes = decodeBytes(bytes);
            writeToFile(decoded, decodedBytes);
        } else {
            System.out.println("File: " + received.getName() + " does not exist.");
        }
    }

    private byte[] readFile(File file) {
        byteReader = new ByteReader(file);
        return byteReader.getBytes();
    }

    private void writeToFile(File file, byte[] bytes) {
        writer = new ByteWriter(file);
        writer.saveMessage(bytes);
    }

    private byte[] provideErrors(byte[] bytes) {
        random = new Random();
        errorMaker = new ErrorMaker(random);
        errorMaker.setBytes(bytes);
        return errorMaker.getBytesWithErrors();
    }

    private byte[] encodeBytes(byte[] bytes) {
        encoder = new Encoder(bytes);
        return encoder.encodedMessage();
    }

    private byte[] decodeBytes(byte[] bytes) {
        decoder = new Decoder(bytes);
        return decoder.decodeMessage();
    }
}
