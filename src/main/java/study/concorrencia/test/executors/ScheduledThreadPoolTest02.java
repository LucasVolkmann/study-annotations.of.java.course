package study.concorrencia.test.executors;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest02 {

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper() {

        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");
            System.out.print("Sleeping");
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();

        };

        // Executa após o tempo especificado
//        executor.schedule(r, 5, TimeUnit.SECONDS);

        // Loop de execução, executa o runnable após a task terminar e passar o tempo
        ScheduledFuture<?> withDelay = executor.scheduleWithFixedDelay(r, 1, 3, TimeUnit.SECONDS);

        // Loop de execução, executa o runnable após o tempo determinado
//        ScheduledFuture<?> withRate = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);

        executor.schedule(() -> {
            System.out.println("Cancelando 'scheduleWithFixedDelay'");
            withDelay.cancel(false);
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);


    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }

}
