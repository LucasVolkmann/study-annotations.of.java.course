package study.threads.test.sincronismo;

public class DeadLockTest01 {
    public static void main(String[] args) {

        // Formando um DEADLOCK

        // Cria-se 2 objetos
        Object objeto1 = new Object();
        Object objeto2 = new Object();

        // Implementa-se a thread 1 lockando o objeto 1 e
        // tentando acessar o objeto 2
        Runnable thread1 = () -> {
            synchronized (objeto1){
                System.out.println("Thread 1 segurando o Objeto 1...");
                System.out.println("Thread 1 esperando o Objeto 2...");
                synchronized (objeto2){
                    System.out.println("Thread 1 segurando Objeto 2");
                }
            }
        };

        // Implementa-se a thread 2 lockando o objeto 2 e
        // tentando acessar o objeto 1
        Runnable thread2 = () -> {
            synchronized (objeto2){
                System.out.println("Thread 2 segurando o Objeto 2...");
                System.out.println("Thread 2 esperando o Objeto 1...");
                synchronized (objeto1){
                    System.out.println("Thread 2 segurando Objeto 1");
                }
            }
        };

        // Inicia-se as duas threads
        new Thread(thread1).start();
        new Thread(thread2).start();

        // Como cada thread vai começar lockando um objeto
        // e em seguida vai tentar acessar o outro objeto que a outra
        // thread está lockando, as threads se travam e o programa
        // não consegue continuar mais

        // Única saida é parar o programa e iniciar novamente


        // Para evitar, remove-se o cruzamento entre
        // thread 1 obj 1 e
        // thread 2 obj 2

//        thread1 = () -> {
//            synchronized (objeto2){
//                System.out.println("Thread 1 segurando o Objeto 2...");
//                System.out.println("Thread 1 esperando o Objeto 1...");
//                synchronized (objeto1){
//                    System.out.println("Thread 1 segurando Objeto 1");
//                }
//            }
//        };

    }
}
