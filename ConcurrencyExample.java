package Shapes;

public class ConcurrencyExample {
    public static void main(String[] args) {
        //Shared lock object to coordinate threads
        Object lock = new Object();
        boolean[] isThreadOneDone = {false}; //Shared flag to signal when Thread 1 is done

        //Thread 1: Counts up to 20
        Thread counterUp = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 1; i <= 20; i++) {
                        System.out.println("Thread 1 counting up: " + i);
                        Thread.sleep(100); //Simulate work
                    }
                    isThreadOneDone[0] = true; //Signal that Thread 1 is done
                    lock.notifyAll(); //Notify all waiting threads
                }
            } catch (InterruptedException e) {
                System.err.println("Thread 1 interrupted: " + e.getMessage());
            }
        });

        //Thread 2: Counts down from 20
        Thread counterDown = new Thread(() -> {
            try {
                synchronized (lock) {
                    while (!isThreadOneDone[0]) {
                        lock.wait(); //Wait for notification from Thread 1
                    }
                    for (int i = 20; i >= 0; i--) {
                        System.out.println("Thread 2 counting down: " + i);
                        Thread.sleep(100); //Simulate work
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("Thread 2 interrupted: " + e.getMessage());
            }
        });

        //Start both threads
        counterUp.start();
        counterDown.start();

        //Ensure main thread waits for both threads to finish
        try {
            counterUp.join();
            counterDown.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Both threads have completed execution.");
    }
}
