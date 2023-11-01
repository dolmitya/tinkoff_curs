package edu.hw2.task3;

import java.util.Random;

public class PopularCommandExecutor {

    public PopularCommandExecutor() {
    }

    private static final String ERROR = "Error";
    private ConnectionManager manager;
    private int maxAttempts;

    PopularCommandExecutor(int maxAttempts) {
        final int intBOUND = 2;
        Random random = new Random();
        manager = (random.nextInt(intBOUND) == 1) ? new DefaultConnectionManager() : new FaultyConnectionManager();
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        final Connection connection = manager.getConnection();
        boolean fl = true;
        if (maxAttempts == 0) {
            throw new ConnectionException(ERROR, new RuntimeException());
        }
        for (int cnt = 1; cnt <= maxAttempts && fl; cnt++) {
            try (connection) {
                connection.execute(command);
                fl = false;
            } catch (ConnectionException e) {
                fl = true;
                if (cnt == maxAttempts) {
                    throw new ConnectionException(ERROR, new RuntimeException());
                }
            }
        }
        connection.close();
    }
}
