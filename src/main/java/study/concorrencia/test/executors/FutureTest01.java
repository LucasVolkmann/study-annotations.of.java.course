package study.concorrencia.test.executors;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {

            TimeUnit.SECONDS.sleep(5);

            return 5.99D;
        });

        System.out.println(doSomething() + " times");

        Double dollarResponse = null;
        try {
            dollarResponse = dollarRequest.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        System.out.println("Dollar: " + dollarResponse);

    }

    private static double doSomething() {

        System.out.printf("%s is doing something ", Thread.currentThread().getName());

        double sum = 0;
        for (int i = 0; i < 100_000; i++) {
            sum += i;
        }

        return sum;
    }

}
