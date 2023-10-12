package study.concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {

        TransferQueue<Object> tq = new LinkedTransferQueue<>();

        // Lança uma exceção se não houver espaço
        System.out.println(tq.add("Fábio"));

        // Retorna um boolean se conseguiu ou não adicionar
        System.out.println(tq.offer("Fábio"));
        System.out.println(tq.offer("Fábio", 10, TimeUnit.SECONDS));

        // Tenta inserir e espera se não houver espaço
        tq.put("Fábio");

        // Verifica se há um consumidor pegando os valores inseridos
        if (tq.hasWaitingConsumer()) {
            // Adiciona e espera um consumidor pegar
            tq.transfer("Fábio");
        }

        // Tenta transferir um elemento para um consumidor esperando,
        // se conseguir retorna TRUE, se não FALSE
        System.out.println(tq.tryTransfer("Fábio"));

        // Tenta pelo tempo determinado
        System.out.println(tq.tryTransfer("Fábio", 3, TimeUnit.SECONDS));

        // Retorna e não remove o primeiro elemento da lista
        // (Lança exceção)
        System.out.println(tq.element());

        // Retorna e não remove o primeiro elemento da lista
        // (Não lança exceção) retorna null se a lista estiver vazia
        System.out.println(tq.peek());

        // Retorna e remove o primeiro elemento da lista
        // retorna null se ela estiver vazia
        System.out.println(tq.poll());

        // Retorna e remove o primeiro elemento da lista
        // lança uma exceção se ela estiver vazia
        System.out.println(tq.remove());

        // Retorna o espaço total de inserção
        System.out.println(tq.remainingCapacity());

    }
}
