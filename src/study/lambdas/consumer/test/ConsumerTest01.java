package study.lambdas.consumer.test;

import java.util.List;
import java.util.function.Consumer;

    /*
        Consumer <T> {
            void accept(T t);
        }
     */

public class ConsumerTest01 {
    public static void main(String[] args) {

        List<String> frases = List.of(
                "A vida é muito curta para ser pequena.",
                "Se você não alcançou seu objetivo, porque está descansando tanto?",
                "Se estiver passando pelo inferno, continue andando.",
                "Acredite em milagres, mas não dependa deles."
        );

        paraCada(frases, frase -> System.out.println(frase.toUpperCase()+"\n"));

    }

    // Método genérico que imprime qualquer lista
    private static <T> void paraCada(List<T> list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }
    }

}
