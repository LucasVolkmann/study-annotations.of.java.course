package study.jdbc.test;

import study.jdbc.domain.Producer;
import study.jdbc.repository.ProducerRepository;

import java.util.Scanner;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        String name;
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Name to insert: ");
            name = s.nextLine();
        }
        Producer producer = Producer.ProducerBuilder.builder().name(name).build();
        ProducerRepository.save(producer);
    }
}
