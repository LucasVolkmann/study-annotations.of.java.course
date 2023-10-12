package study.threads.test;

class ThreadExampleRunnable2 implements Runnable {

    private final char c;

    public ThreadExampleRunnable2(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("\n" + Thread.currentThread().getName());

        for (int i = 1; i < 501; i++) {
            System.out.print(c);
            if (i % 50 == 0) {
                System.out.println();
            }

            try {

                // Quando a thread chegar nessa linha de código ela
                // garantidamente irá parar!!!
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


public class PrioridadeESleepTest01 {
    public static void main(String[] args) {

        // -------------------------------------------------> é possível nomear as threads
        Thread t1 = new Thread(new ThreadExampleRunnable2('A'), "THREAD 1 [A]");
        Thread t2 = new Thread(new ThreadExampleRunnable2('B'), "THREAD 2 [B]");
        Thread t3 = new Thread(new ThreadExampleRunnable2('C'), "THREAD 3 [C]");
        Thread t4 = new Thread(new ThreadExampleRunnable2('D'), "THREAD 4 [D]");

        //Setando a prioridade da Thread

        // *não significa que ela terá prioridade, apenas indicamos para o
        // scheduler a prioridade que a gente quer para ela

        // *NÃO É RECOMENDADO se basear nessas prioridades

        // Normalmente o range de prioridade vai de 1 a 10(varia de acordo com a JVM),
        t1.setPriority(10);


        // O indicado é setar a prioridade com Enuns:
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t4.setPriority(Thread.MAX_PRIORITY);


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("######################################" + Thread.currentThread().getName());


    }
}
