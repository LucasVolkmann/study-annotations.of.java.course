package study.threads.service;

import study.threads.domain.Members;

// Criando uma thread implementando runnable
public class EmailDeliveryService implements Runnable{

    // Tem como atributo um 'Members'
    private final Members members;

    // Pede um member na hora de criar a classe pois o member é final
    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName +" starting to deliver emails...");

        // Verifica se o membro ainda está aberto ou se ainda há emails para enviar
        while(members.isOpen() || members.pendingEmails() > 0){

            try {
                // Define uma String 'email', chamando um método de retorno
                // da classe Members
                String email = members.retrieveEmail();

                // Se ele for null (O que significa que a classe members está fechada)
                // ele da um continue e não passará no while
                if(email == null) continue;

                // 'Envia o email'
                System.out.println(threadName + " enviando email para "+email);
                Thread.sleep(2000);
                System.out.println(threadName + " enviou email com sucesso para "+email);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Quando não houver mais emails e a classe Member estiver fechada:
        System.out.println("Todos os emails foram enviados com sucesso!");
    }
}