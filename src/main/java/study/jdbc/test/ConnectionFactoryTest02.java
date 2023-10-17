package study.jdbc.test;

import lombok.extern.log4j.Log4j2;
import study.jdbc.domain.Producer;
import study.jdbc.service.ProducerServiceRowSet;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Producer producerToUpdate = Producer.builder()
                .id(1)
                .name("updated-with-cached-rowset-first-producer")
                .build();

//        ProducerServiceRowSet.updateJdbcRowSet(producerToUpdate);
        ProducerServiceRowSet.updateCachedRowSet(producerToUpdate);

//        log.info("-----------------------------------");
//        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
//        log.info(producers);
    }
}
