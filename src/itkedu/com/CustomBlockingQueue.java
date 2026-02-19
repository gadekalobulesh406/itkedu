package itkedu.com;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<T> {

    private Queue<T> queue;
    private int capacity;

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    // Add element (Producer)
    public synchronized void enqueue(T item) throws InterruptedException {

        while (queue.size() == capacity) {
            wait(); // Wait until space is available
        }

        queue.add(item);
        notifyAll(); // Notify waiting consumers
    }

    // Remove element (Consumer)
    public synchronized T dequeue() throws InterruptedException {

        while (queue.isEmpty()) {
            wait(); // Wait until item is available
        }

        T item = queue.remove();
        notifyAll(); // Notify waiting producers
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }

    // MAIN METHOD (Demo)
    public static void main(String[] args) {

        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(3);

        // Producer
        Thread producer = new Thread(() -> {
            int value = 1;
            try {
                while (true) {
                    queue.enqueue(value);
                    System.out.println("Produced: " + value);
                    value++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int item = queue.dequeue();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
