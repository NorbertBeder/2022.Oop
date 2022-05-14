package lab12_2;

public class Lab12Main {
    public static void main(String[] args) {
        Storage storage = new Storage("data1000000.txt");

        double startTime = System.nanoTime();
        storage.update("update1000000.txt");
        double stopTime = System.nanoTime();
        System.out.println("\tExecution time: " + (stopTime - startTime) / 1000000000);
        System.out.println();
    }
}
