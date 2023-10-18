package study.crud.service;

import study.crud.domain.Producer;
import study.crud.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }
    }

    private static void findByName() {
        System.out.print("Type the name or empty to all:\n>> ");
        String name = SCANNER.nextLine();
        ProducerRepository.findByName(name).forEach( p ->
                System.out.printf("[%d] - %s%n", p.getId(), p.getName())
        );
    }

    private static void delete(){
        System.out.print("Type the id of producer you want to delete:\n>> ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Are you sure? (Y/N)\n>> ");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)){
            ProducerRepository.delete(id);
        }
    }

    private static void save(){
        System.out.print("Insert the producer name: ");
        String name = SCANNER.nextLine();
        ProducerRepository.save(
                Producer.builder().name(name).build());
    }

    private static void update() {
        System.out.print("Insert the producer id: ");
        Optional<Producer> producerFounded =
                ProducerRepository.findById(
                        Integer.parseInt(SCANNER.nextLine()));
        if (producerFounded.isEmpty()) {
            System.out.println("Producer not founded.");
            return;
        }
        Producer producerFromDb = producerFounded.get();
        System.out.println("Producer founded: " + producerFromDb);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;

        Producer producerToUpdate = Producer.builder()
                .id(producerFromDb.getId())
                .name(name)
                .build();

        ProducerRepository.update(producerToUpdate);
    }




}
