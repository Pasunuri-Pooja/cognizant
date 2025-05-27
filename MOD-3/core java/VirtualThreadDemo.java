public class VirtualThreadDemo {
    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting virtual threads...");
        long vtStart = System.currentTimeMillis();
        Thread[] vthreads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            vthreads[i] = Thread.startVirtualThread(() -> {
                // Minimal work to keep it quick
                System.out.println("Hello from virtual thread " + Thread.currentThread().threadId());
            });
        }
        for (Thread t : vthreads) {
            t.join();
        }
        long vtEnd = System.currentTimeMillis();
        System.out.println("Virtual threads completed in " + (vtEnd - vtStart) + " ms");

        System.out.println("\nStarting traditional threads...");
        long ttStart = System.currentTimeMillis();
        Thread[] tthreads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            tthreads[i] = new Thread(() -> {
                System.out.println("Hello from traditional thread " + Thread.currentThread().getId());
            });
            tthreads[i].start();
        }
        for (Thread t : tthreads) {
            t.join();
        }
        long ttEnd = System.currentTimeMillis();
        System.out.println("Traditional threads completed in " + (ttEnd - ttStart) + " ms");
    }
}
