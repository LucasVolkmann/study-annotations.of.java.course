package study.threads.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {

    // Lista de emails sendo thread safe
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);

    // Identificador de abertura
    private boolean open = true;

    // Método que retorna se o objeto está aberto ou não
    public boolean isOpen() {
        return open;
    }

    // Método que retorna a quantidade de emails do objeto
    public int pendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    // Método que adiciona um email na lista
    public void addMemberEmail(String email) {

        // Pega o lock do objeto
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");

            // Add o email na lista
            this.emails.add(email);

            // Comunica as outras Threads para sairem do modo espera
            this.emails.notifyAll();
        }
    }

    // Método de obtenção de email da lista
    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");

        // Pega o lock do objeto
        synchronized (this.emails) {

            // Cria um laço para a thread continuar dentro do método enquanto
            // não houver emails para pegar (Evitando que a thread acabe)
            while (this.emails.size() == 0) {

                // Verifica se o Objeto está 'aberto'
                if (!open) return null;

                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");

                // Thread que pegou o lock entra em modo de espera
                this.emails.wait();
                System.out.println(Thread.currentThread().getName() + " saindo do modo espera");

            }

            // Se houver algum elemento na lista retorna ele
            return this.emails.poll();
        }
    }

    // Método para fechar o objeto
    public void close() {
        open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando emails");
            // Faz as threads 'andarem' para se encerrarem sozinhas
            this.emails.notifyAll();
        }
    }
}