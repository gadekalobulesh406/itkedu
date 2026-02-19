package itkedu.com;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFactorial {

    //  FactorialTask
    static class FactorialTask extends RecursiveTask<Long> {

        private final int start;
        private final int end;
        private static final int THRESHOLD = 5; // when to stop splitting

        public FactorialTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            // Base case: small range → compute directly
            if ((end - start) <= THRESHOLD) {
                long result = 1;
                for (int i = start; i <= end; i++) {
                    result *= i;
                }
                return result;
            }

            // Split task into two halves
            int mid = (start + end) / 2;

            FactorialTask leftTask = new FactorialTask(start, mid);
            FactorialTask rightTask = new FactorialTask(mid + 1, end);

            // Asynchronous execution
            leftTask.fork();

            // Compute right directly
            long rightResult = rightTask.compute();

            // Wait for left result
            long leftResult = leftTask.join();

            // Combine results
            return leftResult * rightResult;
        }
    }

    //  Main Method
    public static void main(String[] args) {

        int number = 10;

        ForkJoinPool pool = new ForkJoinPool();

        FactorialTask task = new FactorialTask(1, number);

        long result = pool.invoke(task);

        System.out.println("Factorial of " + number + " = " + result);

        pool.shutdown();
    }
}

