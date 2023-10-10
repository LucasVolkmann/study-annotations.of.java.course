package study.concorrencia.test;

import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockReviewTest01 {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        new Thread( () -> {

            lock.lock();
            System.out.println(Thread.currentThread().getName() + " está dentro do lock");
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.print(". ");
                }
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " saiu do lock");
            }
        } ).start();



        new Thread( () -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " está dentro do lock");
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.print(". ");
                }
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " saiu do lock");
            }
        } ).start();


    }

}
