package study.streams.test.gerando_streams;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class GerandoStreamsTest02 {

    // GERANDO STREAMS INFINITAS

    public static void main(String[] args) {

        //Imprimir todos os números múltiplos de 7 de 0 a 100
        Stream.iterate(7 , n -> n + 7) // (numInicial, T lambda(T))
                .limit(14) // Número de elementos
                .forEach(System.out::println);
        System.out.println("-------------");


        //Imprimir a sequência de Fibonacci
        Stream.iterate(

        // No primeiro termo eu crio um novo array e seto os valores iniciais
                new int[]{0,1},
        // Crio um novo array e seto os valores de acordo com os valores do array antigo
                array -> new int[]{array[1], array[0] + array[1]})

                .limit(10)
        // Pego cada array do Stream e printo a posição [0]
                .forEach(array -> System.out.println(Arrays.toString(array)));


        // Fibonacci transformando o array em int com o "map()"
        Stream.iterate(new int[]{0, 1}
        , array -> new int[]{array[1], array[0] + array[1]})
                .map( array -> array[0] )
                .limit(10)
                .forEach(n -> System.out.print(n+ " "));
        System.out.println();



        // G E N E R A T E ( Suplier = () -> return )
        // Gerando 10 números aleatórios ( 0 ou 1 )
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate( () -> random.nextInt(0, 2) )
                .limit(10)
                .forEach(System.out::println);
    }
}
