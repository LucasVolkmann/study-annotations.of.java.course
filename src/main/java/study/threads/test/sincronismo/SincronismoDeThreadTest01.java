package study.threads.test.sincronismo;

import study.threads.domain.Account;

// Para facilitar a acompreenção implemento Runnable nessa classe mesmo
public class SincronismoDeThreadTest01 implements Runnable {

    //Crio uma conta nova onde as duas threads vão acessar ao mesmo tempo
    private Account account = new Account();

    public static void main(String[] args) {

        SincronismoDeThreadTest01 s = new SincronismoDeThreadTest01();

        // As duas threads criadas vão acessar o mesmo objeto 'account'
        Thread t1 = new Thread(s, "JOÃO");
        Thread t2 = new Thread(s, "CARLOS");
        t1.start();
        t2.start();

    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            // Tenta realizar o saque de 10 da conta
            withdrawal(10);

            if (account.getBalance() < 0) {
                // Se entrou aqui significa que o saldo da conta é negativo
                // o que é uma falha no sistema
                System.out.println("####################################### FODEO");

            }
        }
    }

    private void withdrawal(int amount) {

        if (account.getBalance() >= amount) {

            // A thread A pode entrar nesse if e parar nesse momento antes de entrar
            // no método de saque, e então a thread B pode entrar também, se o
            // saldo nesse momento for de 10 as duas threads vão sacar juntas 20,
            // e o saldo final será -10

            System.out.println(getName() + " está indo sacar o dinheiro");
            account.withdrawal(amount);
            System.out.println(getName() + " completou o saque. Saldo final: " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getName() + " efetuar o saque. Saldo atual: " + account.getBalance());
        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }
}
