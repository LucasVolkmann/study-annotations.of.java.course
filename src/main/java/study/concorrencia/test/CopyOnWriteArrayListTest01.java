package study.concorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteArrayListTest01 {
    public static void main(String[] args) {

        List<Integer> integers = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 200; i++) {
            integers.add(i);
        }

        Runnable runnableIteraror = () -> {
            Iterator<Integer> iterator = integers.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnableRemover = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.printf("%s removed %d from integers list!%n", Thread.currentThread().getName(), integers.remove(0));
            }
        };

        new Thread(runnableIteraror).start();
        new Thread(runnableRemover).start();

    }
}
