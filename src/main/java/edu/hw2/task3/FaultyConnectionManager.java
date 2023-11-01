package edu.hw2.task3;

public class FaultyConnectionManager implements ConnectionManager {
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
