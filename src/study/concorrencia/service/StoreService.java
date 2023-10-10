package study.concorrencia.service;

import java.util.concurrent.*;

public class StoreService {

    private static final ExecutorService ex = Executors.newCachedThreadPool();

    // PEGANDO OS PREÇOS DE FORMA SINCRONA
    public double getPriceSync(String storeName){
        System.out.printf("Getting prices sync for store%s%n", storeName);
        return priceGenerator();
    }

    // PEGANDO OS PREÇOS DE FORMA ASSÍNCRONA ( UTILIZANDO O EXECUTOR )
    public Future<Double> getPricesAsyncFuture(String storeName){
        System.out.printf("Getting prices sync for store%s%n", storeName);
        return ex.submit(this::priceGenerator);
    }

    // PEGANDO OS PREÇOS DE FORMA ASSÍNCRONA ( UTILIZANDO O COMPLETABLE FUTURE )
    // não necessita abrir e fechar um executor
    public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName){
        System.out.printf("Getting prices sync for store%s%n", storeName);
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }

    public static void shutdown() {
        ex.shutdown();
    }

    private double priceGenerator(){
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delayFor2s();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10  ;
    }

    private void delayFor2s(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
