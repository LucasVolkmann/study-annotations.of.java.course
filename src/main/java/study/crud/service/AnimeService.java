package study.crud.service;

import study.crud.domain.Anime;
import study.crud.domain.Producer;
import study.crud.repository.AnimeRepository;
import study.crud.repository.ProducerRepository;

import java.util.Optional;
import java.util.Scanner;

public class AnimeService {

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
        System.out.print("Type the anime name or empty to all:\n>> ");
        String name = SCANNER.nextLine();
        AnimeRepository.findByName(name).forEach( a ->
                System.out.printf("[%d] - name:%s | episodes:%d | producer:%s%n", a.getId(), a.getName(), a.getEpisodes(), a.getProducer())
        );
    }

    private static void delete(){
        System.out.print("Type the id of anime you want to delete:\n>> ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Are you sure? (Y/N)\n>> ");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)){
            AnimeRepository.delete(id);
        }
    }

    private static void save(){
        System.out.print("Insert the anime name: ");
        String name = SCANNER.nextLine();
        System.out.print("Insert the number of episodes: ");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.println("List of Producers: ");
        ProducerRepository.findByName("").forEach(p ->
                System.out.printf("[%d] - %s%n", p.getId(), p.getName())
        );
        System.out.print("Insert the producer id: ");
        int producerId = Integer.parseInt(SCANNER.nextLine());
        AnimeRepository.save(
                Anime.builder()
                        .name(name)
                        .episodes(episodes)
                        .producer(Producer.builder()
                                .id(producerId)
                                .build())
                        .build());
    }

    private static void update() {
        System.out.print("Insert the anime id: ");
        Optional<Anime> producerFounded =
                AnimeRepository.findById(
                        Integer.parseInt(SCANNER.nextLine()));
        if (producerFounded.isEmpty()) {
            System.out.println("Anime not founded.");
            return;
        }
        Anime animeFromDb = producerFounded.get();
        System.out.println("Anime founded: " + animeFromDb);

        System.out.print("Type the new name or enter to keep the same: ");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;

        System.out.print("Type the new number of episodes: ");
        int episodes = Integer.parseInt(SCANNER.nextLine());

        System.out.print("Type the new producer id: ");
        int producerId = Integer.parseInt(SCANNER.nextLine());

        Anime animeToUpdate = Anime.builder()
                .id(animeFromDb.getId())
                .name(name)
                .episodes(episodes)
                .producer(Producer.builder()
                        .id(producerId)
                        .build())
                .build();

        AnimeRepository.update(animeToUpdate);
    }




}
