package study.jdbc.test;

import lombok.extern.log4j.Log4j2;
import study.jdbc.domain.Producer;
import study.jdbc.service.ProducerService;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("producer-name").build();
        Producer producerToUpdate = Producer.builder()
                .id(1)
                .name("updated-first-producer")
                .build();

//        ProducerService.save(producer);
//        ProducerService.delete(3);
//        ProducerService.update(producerToUpdate);
//        List<Producer> producers = ProducerService.findAll();
//        List<Producer> producers = ProducerService.findByName("first");
//        log.info("Producers found: '{}'", producers);

//        ProducerService.showProducerMetaData();
//        ProducerService.showDriverMetaData();
//        ProducerService.showTypeScrollWorking();

        List<Producer> producers = ProducerService.findByNameAndUptdateToUpperCase("marcelo");
        log.info("Producers found: '{}'", producers);
    }


}
