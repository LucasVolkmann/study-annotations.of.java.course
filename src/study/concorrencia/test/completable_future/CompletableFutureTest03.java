package study.concorrencia.test.completable_future;

import study.concorrencia.service.StoreService;
import study.concorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFuture(storeServiceDeprecated);
    }

    private static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated storeServiceDeprecated) {

        ExecutorService executorService = Executors.newFixedThreadPool(10, r -> {

            // Consigo criar uma ThreadFactory
            // Onde posso manipular a Thread da maneira que eu quiser
            Thread t = new Thread(r, "Germán Cano");
            t.setDaemon(true);

            return t;
        });

        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(
                        () -> storeServiceDeprecated.getPriceSync(s),
                        executorService /*Método sobrecarregado que aceita um Executor,
                        que fará o CompletableFuture utilizar essas threads passadas*/ ))
                .toList();

        List<Double> prices = completableFutures.stream()
                .map(CompletableFuture::join).toList();

        System.out.println(prices);

        long end = System.currentTimeMillis();

        executorService.shutdown();

        System.out.printf("Time passed to [searchPricesAsyncCompletableFuture] %dms%n", (end - start));
    }

}
