package study.threads.test.sincronismo;

import study.threads.domain.Members;
import study.threads.service.EmailDeliveryService;

import javax.swing.*;

public class WaitNotifyENotifyAllTest01 {
    public static void main(String[] args) {

        // Cria um member para passar para as duas threads
        Members members = new Members();

        // Inicia as duas threads
        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");
        jiraya.start();
        kakashi.start();

        // Thread main ficará recebendo emails até que não seja mais passado nenhum
        while (true) {

            // Define uma String com o valor recebido
            String email = JOptionPane.showInputDialog("Entre com seu email");

            // Verifica se o valor passado é nulo ou lenght() == 0
            if (email == null || email.isEmpty()) {

                // Chama o método que fecha a classe Member
                members.close();

                // 'Quebra' o laço while
                break;
            }

            // Se não passar no if ele adiciona a string na lista de emails
            members.addMemberEmail(email);
        }
    }
}
