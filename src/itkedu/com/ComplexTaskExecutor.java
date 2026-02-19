package itkedu.com;

import java.util.concurrent.*;
import java.util.*;

public class ComplexTaskExecutor {

    // Complex Task
    static class ComplexTask implements Callable<Integer> {

        private int taskId;

        public ComplexTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public Integer call() throws Exception {

            System.out.println("Task " + taskId + " started by " +
                    Thread.currentThread().getName());

            // Simulate complex computation
            Thread.sleep(1000 + new Random().nextInt(2000));

            int result = taskId * 10;

            System.out.println("Task " + taskId + " finished with result: " + result);

            return result;
        }
    }

    // 2Execute tasks using ExecutorService + CyclicBarrier
    public void executeTasks(int numberOfTasks) {

        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        // Barrier action → runs when all threads reach barrier
        CyclicBarrier barrier = new CyclicBarrier(numberOfTasks, () -> {
            System.out.println("\nAll tasks completed. Combining results...");
            int sum = results.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Final Combined Result = " + sum);
        });

        for (int i = 1; i <= numberOfTasks; i++) {

            int taskId = i;

            executor.submit(() -> {
                try {
                    ComplexTask task = new ComplexTask(taskId);
                    int result = task.call();

                    results.add(result);

                    // Wait for all threads
                    barrier.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }

    //  MAIN METHOD
    public static void main(String[] args) {

        ComplexTaskExecutor executor = new ComplexTaskExecutor();
        executor.executeTasks(5);
    }
}
