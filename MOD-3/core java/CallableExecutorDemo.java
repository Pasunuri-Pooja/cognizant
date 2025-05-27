import java.util.concurrent.*;
import java.util.*;

public class CallableExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();

        // Add tasks that return a string after some work
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            tasks.add(() -> {
                // Simulate some work with sleep
                Thread.sleep(500);
                return "Result from task " + taskId;
            });
        }

        // Submit all tasks and get a list of Futures
        List<Future<String>> futures = executor.invokeAll(tasks);

        // Retrieve and print results from Futures
        for (Future<String> future : futures) {
            // get() waits if necessary for the computation to complete
            String result = future.get();
            System.out.println(result);
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
