package study.concorrencia.test.executors;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {

            TimeUnit.SECONDS.sleep(5);

            return 5.99;
        });

        System.out.println(doSomething() + " times");

        double dollarResponse = dollarRequest.get(2, TimeUnit.SECONDS);

        System.out.println("Dollar: " + dollarResponse);

        executorService.shutdown();
    }

    private static double doSomething(){

        System.out.printf("%s is doing something ", Thread.currentThread().getName());

        double sum = 0;
        for (int i = 0; i < 100_000; i++) {
            sum += i;
        }

        return sum;
    }

}
