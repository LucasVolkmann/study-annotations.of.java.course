package study.concorrencia.service;

import java.util.concurrent.*;

public class StoreServiceDeprecated {

    public double getPriceSync(String storeName){
        System.out.printf("Getting prices sync for store%s%n", storeName);
        return priceGenerator();
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
