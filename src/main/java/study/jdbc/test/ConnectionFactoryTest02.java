package study.jdbc.test;

import lombok.extern.log4j.Log4j2;
import study.jdbc.domain.Producer;
import study.jdbc.service.ProducerServiceRowSet;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("first");
        log.info(producers);
    }
}
