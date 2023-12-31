package study.concorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();

    // Se eu adicionar a flag syncronized nesse método a contagem funciona normalmente,
    // mas a performance do programa é afetada
    public void increment() {
        // incrementando o AtomicInteger (Sem sincronismo)
        atomicInteger.incrementAndGet();
        count++;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public int getCount() {
        return count;
    }
}

public class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t2.join();

        System.out.println("int = " + counter.getCount());
        System.out.println("AtomicInteger = " + counter.getAtomicInteger());


    }
}
