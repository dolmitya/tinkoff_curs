package edu.hw2.task3;

@SuppressWarnings("uncommentedmain")
public class Task3 {

    private Task3() {
    }

    public static void main(String[] args) throws Exception {
        PopularCommandExecutor executor;
        executor = new PopularCommandExecutor(1);
        executor.updatePackages();
    }
}
