package study.jdbc.test;

import study.jdbc.domain.Producer;
import study.jdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Martinelli").build();
        Producer producer2 = Producer.builder().name("Guga").build();
        Producer producer3 = Producer.builder().name("Lima").build();
        ProducerService.saveTransaction(List.of(producer1, producer2, producer3));
    }
}
