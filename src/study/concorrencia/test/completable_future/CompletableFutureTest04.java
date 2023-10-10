package study.concorrencia.test.completable_future;

import study.concorrencia.domain.Quote;
import study.concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
//        searchPricesWithDiscount(service);
        serachPricesWithDiscountAsync(service);
    }


    private static void searchPricesWithDiscount(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));
//        stores.stream()
//                .map(storeName -> service.getPriceSync(storeName)) // storeName:price:discountCode
//                .map(patternizedString -> {
//                    Quote q = Quote.newQuote(patternizedString);
//                    return q;
//                })
//                .map(quote -> service.applyDiscount(quote))
//                .forEach(System.out::println);

        stores.stream()
                .map(s -> {
                    String patternizedString = service.getPriceSync(s);
                    Quote q = Quote.newQuote(patternizedString);
                    return service.applyDiscount(q);
                }).forEach(System.out::println);


        long end = System.currentTimeMillis();
        System.out.printf("Time passed to [searchPricesWithDiscount] %dms%n", (end - start));
    }

    private static void serachPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

//        List<CompletableFuture<String>> list = stores.stream()
//                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
//                .map(cf -> cf.thenApply(Quote::newQuote))
//                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
//                .toList();

        List<CompletableFuture<String>> list = stores.stream()
                .map(s -> {
                    CompletableFuture<String> cF = CompletableFuture.supplyAsync(() -> service.getPriceSync(s));
                    CompletableFuture<Quote> quoteCF = cF.thenApply(Quote::newQuote);
                    return quoteCF.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote)));
                }).toList();

        list.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to [serachPricesWithDiscountAsync] %dms%n", (end - start));
    }
}
