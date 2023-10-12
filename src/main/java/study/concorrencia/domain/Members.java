package study.concorrencia.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Members {

    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    public void addMemberEmail(String email) {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");

            this.emails.add(email);
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");

        lock.lock();
        try {
            while (this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");
                condition.await();
                System.out.println(Thread.currentThread().getName() + " saindo do modo espera");
            }
        } finally {
            lock.unlock();
        }
        return this.emails.poll();
    }

    public void close() {
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando emails");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}