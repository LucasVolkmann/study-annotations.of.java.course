package study.threads.test.sincronismo;

import study.threads.domain.Account;

    /*

     -> public synchronized void foo() { }
Esta versão de foo() é um método de instância, ou seja, threads diferentes
podem invocar foo() simultaneamente desde que as chamadas sejam realizadas
em instâncias diferentes. O lock é feito na instância em que foo() foi invocado.

     -> public static synchronized void foo() { }
Já esta versão de foo() só pode ser executada por uma Thread por vez, pois
o lock é feito no objeto Class do tipo em que foo() foi invocado.

Por último o Java ainda permite o uso de blocos synchronized:

     -> public void foo() { synchronized(user) { .... } }
Neste caso, a política de execução vai depender do objeto passado no bloco.
Se for de instância, a trava é feita na instância. Se for um atributo estático,
a trava é feita no objeto Class. Ela te permite uma liberdade maior por permitir
que apenas uma porção do método seja sincronizada

     */

public class SincronismoDeThreadTest02 implements Runnable{
    private final Account account = new Account();

    public static void main(String[] args) {

        SincronismoDeThreadTest02 s = new SincronismoDeThreadTest02();

        Thread t1 = new Thread(s, "JOÃO");
        Thread t2 = new Thread(s, "CARLOS");
        t1.start();
        t2.start();

    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            withdrawal2(10);

            if (account.getBalance() < 0){
                System.out.println("####################################### FODEO");
            }
        }
    }

    // ADICIONANDO A ASSINATURA syncronized NO MÉTODO
    // Tornando o método atômico e impossivel de ser acessado por 2
    // threads ao mesmo tempo
    private synchronized void withdrawal(int amount) {

        if (account.getBalance() >= amount) {
            System.out.println(getName() + " está indo sacar o dinheiro");
            account.withdrawal(amount);
            System.out.println(getName() + " completou o saque. Saldo final: " + account.getBalance());
        } else {
            System.out.println("Sem dinheiro para " + getName() + " efetuar o saque. Saldo atual: " + account.getBalance());
        }
    }

    private void withdrawal2(int amount) {

        System.out.println(getName()+" está fora do synchronized ---------- >>>");
        // Criando um bloco de código atômico
        // * É recomendado que o objeto sincronizado seja final
        synchronized (account) {

            System.out.println(getName()+" está dentro do synchronized ---------- <<<");

            if (account.getBalance() >= amount) {
                System.out.println(getName() + " está indo sacar o dinheiro");
                account.withdrawal(amount);
                System.out.println(getName() + " completou o saque. Saldo final: " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para " + getName() + " efetuar o saque. Saldo atual: " + account.getBalance());
            }

        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }
}
