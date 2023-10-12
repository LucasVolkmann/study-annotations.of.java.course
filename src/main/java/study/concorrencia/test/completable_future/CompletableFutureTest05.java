package study.concorrencia.test.completable_future;

import study.concorrencia.domain.Quote;
import study.concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
//        searchPricesWithDiscount(service);
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        var completableFutures =
                stores.stream()

                        .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))

                        .map(cf -> cf.thenApply(Quote::newQuote))

                        .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))

                        .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))

                        .toArray(CompletableFuture[]::new);

        // Para quando o delay de cada Thread é diferente

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures);
        voidCompletableFuture.join();
        System.out.printf("Finished? %b%n", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to [searchPricesWithDiscountAsync] %dms%n", (end - start));
    }
}
