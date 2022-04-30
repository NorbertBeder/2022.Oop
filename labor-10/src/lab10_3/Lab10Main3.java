package lab10_3;

public class Lab10Main3 {
    public static void main(String[] args) {
        Storage storage1 = new Storage("data10.txt ");

        double startTime = System.nanoTime();
        storage1.update("update10.txt");
        double stopTime = System.nanoTime();
        System.out.println("\tExecution time: " + (stopTime - startTime)/1000000000);
        System.out.println();

        //storage2 missing update file

        Storage storage3 = new Storage("data1000.txt ");

        startTime = System.nanoTime();
        storage3.update("update1000.txt");
        stopTime = System.nanoTime();
        System.out.println("\tExecution time: " +(stopTime - startTime)/1000000000);
        System.out.println();

        Storage storage4 = new Storage("data10000.txt ");

        startTime = System.nanoTime();
        storage4.update("update10000.txt");
        stopTime = System.nanoTime();
        System.out.println("\tExecution time: " +(stopTime - startTime)/1000000000);
        System.out.println();

        //innen mar nagyon hosszu a futasi idejuk a metodusoknak, de mukodnek


        Storage storage5 = new Storage("data100000.txt ");

        startTime = System.nanoTime();
        storage5.update("update100000.txt");
        stopTime = System.nanoTime();
        System.out.println("\tExecution time: " +(stopTime - startTime)/1000000000);
        System.out.println();

        Storage storage6 = new Storage("data1000000.txt ");

        startTime = System.nanoTime();
        storage6.update("update1000000.txt");
        stopTime = System.nanoTime();
        System.out.println("\tExecution time: " +(stopTime - startTime)/1000000000);
        System.out.println();

    }
}
