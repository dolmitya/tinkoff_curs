package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

@SuppressWarnings({"MultipleStringLiterals", "RegexpSinglelineJava", "MagicNumber"})
public class Client implements AutoCloseable {

    private SocketChannel client;
    private ByteBuffer buffer;

    public Client() {

    }

    public void start(String host, int port) {
        try {
            client = SocketChannel.open(new InetSocketAddress(host, port));
            buffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendToServer(String message) {
        try {
            buffer.put(message.getBytes(StandardCharsets.UTF_8));
            buffer.clear();
            client.write(buffer);
            System.out.println("Ваня: " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromServer() {
        try {
            buffer.position(0);
            client.read(buffer);
            String response = new String(buffer.array()).trim();
            System.out.println("Сервер: " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        client.close();
        buffer.clear();
    }
}
