package edu.hw2.task3;

import java.util.Random;

public class PopularCommandExecutor {

    public PopularCommandExecutor() {
    }

    final static String ERROR = "Error";
    private ConnectManage.ConnectionManager manager;
    private int maxAttempts;

    PopularCommandExecutor(int maxAttempts) {
        final int intBOUND = 2;
        Random random = new Random();
        manager = (random.nextInt(intBOUND) == 1) ? new ConnectManage.DefaultConnectionManager()
            : new ConnectManage.FaultyConnectionManager();
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        final Connect.Connection connection = manager.getConnection();
        boolean fl = true;
        if (maxAttempts == 0) {
            throw new Task3.ConnectionException(ERROR, new RuntimeException());
        }
        for (int cnt = 1; cnt <= maxAttempts && fl; cnt++) {
            try {
                connection.execute(command);
                fl = false;
            } catch (Task3.ConnectionException e) {
                fl = true;
                if (cnt == maxAttempts) {
                    throw new Task3.ConnectionException(ERROR, new RuntimeException());
                }
            }
        }
        connection.close();
    }
}
