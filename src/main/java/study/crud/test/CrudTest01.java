package study.crud.test;

import study.crud.service.AnimeService;
import study.crud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

            int op;
            while (true) {
                try {
                    menu();
                    op = Integer.parseInt(SCANNER.nextLine());
                    if (op == 0) break;
                    switch (op) {
                        case 1 -> animeMenu(op);
                        case 2 -> producerMenu(op);
                    }
                } catch (Exception e) {
                    System.out.printf("ERROR: [%s]%n", e.getMessage());
                    System.out.println("An unexpected error happened. You were redirected to the main menu.");
                }
            }
    }

    private static void menu() {
        System.out.println("--> [ MENU ]");
        System.out.println("Type the number of your operation: ");
        System.out.println("1. Anime");
        System.out.println("2. Producer");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }

    private static void animeMenu(int op) {
        System.out.println("--> [ ANIME ]");
        System.out.println("Type the number of your operation: ");
        System.out.println("1. Search for anime");
        System.out.println("2. Delete anime");
        System.out.println("3. Save anime");
        System.out.println("4. Update anime");
        System.out.println("9. Go back");
        System.out.print(">> ");
        op = Integer.parseInt(SCANNER.nextLine());
        AnimeService.menu(op);
    }

    private static void producerMenu(int op) {
        System.out.println("--> [ PRODUCER ]");
        System.out.println("Type the number of your operation: ");
        System.out.println("1. Search for producer");
        System.out.println("2. Delete producer");
        System.out.println("3. Save producer");
        System.out.println("4. Update producer");
        System.out.println("9. Go back");
        System.out.print(">> ");
        op = Integer.parseInt(SCANNER.nextLine());
        ProducerService.menu(op);
    }
}
