package study.concorrencia.test.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {

    private final int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s start the object number %d%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }

}


public class ExecutorsTest01 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

//        ExecutorService exs = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors())/2);
//        ExecutorService exs = Executors.newSingleThreadExecutor();
        ExecutorService exs = Executors.newCachedThreadPool();

        exs.execute(new Printer(1));
        exs.execute(new Printer(2));
        exs.execute(new Printer(3));
        exs.execute(new Printer(4));
        exs.execute(new Printer(5));
        exs.execute(new Printer(6));
        exs.shutdown();

    }
}
