// ThreadExample.java

class MyThread implements Runnable {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running: iteration " + i);
            try {
                Thread.sleep(500); // Pause for 0.5 seconds for visibility
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Create runnable objects
        MyThread runnable1 = new MyThread("Thread 1");
        MyThread runnable2 = new MyThread("Thread 2");

        // Create threads with runnable objects
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
