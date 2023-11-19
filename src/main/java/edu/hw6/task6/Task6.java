package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public class Task6 {

    private final static Logger LOGGER = LogManager.getLogger();

    private final static String TCP_PROTOCOL = "TCP";

    private final static String UDP_PROTOCOL = "UDP";

    private final static Map<Integer, String> MAP_OF_CONNECTION = new HashMap<>();

    private final static String OUTPUT_FORMAT = "%-10s%-10s%-10s";

    private final static int MAX_TASK_PORT = 49151;

    private Task6() {
    }

    public static void main(String[] args) {
        someConnections();
        scannPort();
    }

    public static void someConnections() {
        MAP_OF_CONNECTION.put(135, "Telnet");
        MAP_OF_CONNECTION.put(137, "POP3 ");
        MAP_OF_CONNECTION.put(138, "IMAP");
        MAP_OF_CONNECTION.put(139, "NTP ");
        MAP_OF_CONNECTION.put(445, "SMB");
        MAP_OF_CONNECTION.put(546, "AFP");
        MAP_OF_CONNECTION.put(1900, "HTTP Proxy");
        MAP_OF_CONNECTION.put(2177, "SOCKS");
        MAP_OF_CONNECTION.put(3702, "PPTP ");
        MAP_OF_CONNECTION.put(5040, "Squid");
        MAP_OF_CONNECTION.put(5050, "HTTP");
        MAP_OF_CONNECTION.put(5353, "FTP");
        MAP_OF_CONNECTION.put(5355, "SMTP");
        MAP_OF_CONNECTION.put(9010, "SSH");
        MAP_OF_CONNECTION.put(9080, "HTTPS");
        MAP_OF_CONNECTION.put(9100, "DNS");
        MAP_OF_CONNECTION.put(9180, "MySQL");
        MAP_OF_CONNECTION.put(45654, "PostgreSQL");
        MAP_OF_CONNECTION.put(48510, "RDP");
    }

    public static void scannPort() {
        LOGGER.info(OUTPUT_FORMAT.formatted("Протокол", "Порт", "Сервис"));
        for (int port = 0; port <= MAX_TASK_PORT; ++port) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
            } catch (IOException ignore) {
                LOGGER.info(OUTPUT_FORMAT
                    .formatted(TCP_PROTOCOL, port, MAP_OF_CONNECTION.getOrDefault(port, "")));
            }

            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
            } catch (SocketException ignore) {
                LOGGER.info(OUTPUT_FORMAT
                    .formatted(UDP_PROTOCOL, port, MAP_OF_CONNECTION.getOrDefault(port, "")));
            }
        }
    }
}
