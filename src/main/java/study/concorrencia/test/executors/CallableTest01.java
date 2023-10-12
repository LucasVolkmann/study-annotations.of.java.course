package study.concorrencia.test.executors;

import java.util.concurrent.*;

class RandonNumberCallable implements Callable<String> {
    @Override
    public String call() {

        int num = ThreadLocalRandom.current().nextInt(1, 10);

        for (int i = 0; i < num; i++) {
            System.out.printf("%s executing...%n", Thread.currentThread().getName());
        }

        return String.format("%s finished and the number is %d", Thread.currentThread().getName(), num);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RandonNumberCallable randonNumberCallable = new RandonNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(randonNumberCallable);
        System.out.printf("Program's End %s", future.get());

        executorService.shutdown();

    }
}
