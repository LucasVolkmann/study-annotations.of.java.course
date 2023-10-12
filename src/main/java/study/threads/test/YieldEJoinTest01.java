package study.threads.test;

class ThreadExampleRunnable3 implements Runnable {

    private final char c;

    public ThreadExampleRunnable3(char c) {
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
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

// Quando uma thread está sendo executada ela pode se oferecer para se mover
// para fora da CPU virtual e ceder seu tempo de execução para outras threads.
// Isso é feito com uma chamada ao método estático yield() da classe Thread

// Ele é só uma mensagem que a thread manda para o escalonador dizendo:
//“Ei, escalonador, essa seria uma boa hora para outras threads processarem.”
//
//Caso o escalonador decida que é mesmo, ele faz a preempção.
            Thread.yield();

        }
    }
}

public class YieldEJoinTest01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable3('0'));
        Thread t2 = new Thread(new ThreadExampleRunnable3('#'));

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        // Se junta a essa thread e não continua equanto ela não finalizar
        t1.join();

        t2.start();

        System.out.println("---------------------- MAIN ----------------------");
    }
}
