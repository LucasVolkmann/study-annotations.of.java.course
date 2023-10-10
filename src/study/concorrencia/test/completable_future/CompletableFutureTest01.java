package study.concorrencia.test.completable_future;

import study.concorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {

        StoreService storeService = new StoreService();

//        searchPricesSync(storeService);
//        searchPricesAsyncFuture(storeService);
        searchPricesAsyncCompletableFuture(storeService);

    }

    private static void searchPricesSync(StoreService storeService){

        // PESQUISANDO OS PREÇOS DE FORMA SÍNCRONA

        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync(("Store 1")));
        System.out.println(storeService.getPriceSync(("Store 2")));
        System.out.println(storeService.getPriceSync(("Store 3")));
        System.out.println(storeService.getPriceSync(("Store 4")));
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to [searchPricesSync] %dms%n", (end - start));

    }

    private static void searchPricesAsyncFuture(StoreService storeService){

        // PESQUISANDO OS PREÇOS DE FORMA ASSÍNCRONA UTILIZANDO O FUTURE

        long start = System.currentTimeMillis();

        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");

        try {
            System.out.println(pricesAsyncFuture1.get());
            System.out.println(pricesAsyncFuture2.get());
            System.out.println(pricesAsyncFuture3.get());
            System.out.println(pricesAsyncFuture4.get());
        }catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to [searchPricesAsyncFuture] %dms%n", (end - start));
        StoreService.shutdown();

    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {

        // PESQUISANDO OS PREÇOS DE FORMA ASSÍNCRONA UTILIZANDO O COMPLETABLE FUTURE

        long start = System.currentTimeMillis();

        CompletableFuture<Double> pricesAsyncFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");

        System.out.println(pricesAsyncFuture1.join());
        System.out.println(pricesAsyncFuture2.join());
        System.out.println(pricesAsyncFuture3.join());
        System.out.println(pricesAsyncFuture4.join());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to [searchPricesAsyncCompletableFuture] %dms%n", (end - start));
    }

}
