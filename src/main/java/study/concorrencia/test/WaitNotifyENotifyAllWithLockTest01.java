package study.concorrencia.test;

import study.concorrencia.domain.Members;
import study.concorrencia.service.EmailDeliveryService;

import javax.swing.*;

public class WaitNotifyENotifyAllWithLockTest01 {
    public static void main(String[] args) {

        Members members = new Members();

        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");
        jiraya.start();
        kakashi.start();

        while (true) {
            String email = JOptionPane.showInputDialog("Entre com seu email");
            if (email == null || email.isEmpty()) {
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
