package study.concorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {

        // Criando um objeto ArrayBlockingQueue e setando o tamanho para 1
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("Martinelli");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.printf("%s trying to add another value%n", Thread.currentThread().getName(), bq.peek());
        new Thread(new RemoveFromQueue(bq)).start();
        bq.put("Alexsander");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
    }

    static class RemoveFromQueue implements Runnable {

        BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5s%n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s removing %s from queue%n", Thread.currentThread().getName(), bq.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

}
