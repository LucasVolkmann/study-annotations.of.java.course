package study.threads.test;

class ThreadExample extends Thread{

    private final char c;

    public ThreadExample(char c){
        this.c = c;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        for (int i = 1; i < 501; i++) {
            System.out.print(c);
            if(i % 50 == 0){
                System.out.println();
            }
        }

    }
}

class ThreadExampleRunnable implements Runnable{

    private final char c;

    public ThreadExampleRunnable(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        for (int i = 1; i < 501; i++) {
            System.out.print(c);
            if(i % 50 == 0){
                System.out.println();
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {

        // Primeira maneira de criar:
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');

        // Se eu chamar o método 'run()' eu não inicio uma Thread nova,
        // apenas falo pro java rodar o método do objeto t1
//         t1.run();

        // Se eu quiser começar uma Thread nova preciso chamar o 'start()'
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();


        // Maneira recomendada de usar threads
        Thread t1 = new Thread(new ThreadExampleRunnable('A'));
        Thread t2 = new Thread(new ThreadExampleRunnable('B'));
        Thread t3 = new Thread(new ThreadExampleRunnable('C'));
        Thread t4 = new Thread(new ThreadExampleRunnable('D'));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("\n\n####################################" + Thread.currentThread().getName() + "\n\n");

    }
}
