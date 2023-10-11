package study.concorrencia.test.completable_future;

import study.concorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {

        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");

        // Lançando as Threads
        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(storeService::getPricesAsyncCompletableFuture)
                .toList();

        // Coletando os resultados
        List<Double> prices = completableFutures.stream()
                .map(
                        CompletableFuture::join
                ).toList();

        System.out.println(prices);

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to [searchPricesAsyncCompletableFuture] %dms%n", (end - start));
    }

}
