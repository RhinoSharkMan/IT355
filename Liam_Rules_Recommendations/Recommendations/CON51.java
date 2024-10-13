package Liam_Rules_Recommendations.Recommendations;

public class CON51 {
    private static volatile boolean ready = false; //Ensure that updates to its value are made visible across multiple threads 

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (!ready) {
                //Waiting for ready to change
            }
            System.out.println("Thread 1 finished");
        });

        t1.start();
        Thread.sleep(500);  // Time sim
        ready = true;  // Synchronized with volatile
        System.out.println("Main thread updated 'ready'");
    }
}
