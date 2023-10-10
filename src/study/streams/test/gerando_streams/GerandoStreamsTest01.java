package study.streams.test.gerando_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GerandoStreamsTest01 {
    public static void main(String[] args) {

//        | Gerando Streams do zero: |

        // Imprime os números pares de 1 a 50
        IntStream.rangeClosed(1 , 50) // Inclui o 50
                .filter( n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Imprime os números pares de 1 a 50
        IntStream.range(1 , 50) // Exclui o 50
                .filter( n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Transforma um var args em Stream
        Stream.of("Vamos ", "tricolores ", "chegou ", "a ", "hora ", "vamos...")
                .map(String::toUpperCase)
                .forEach(System.out::print);
        System.out.println();

        // Transforma um array em Stream
        int[] inteiros = {1,2,3,4,5};
        Arrays.stream(inteiros) // -> return: IntStream
                .average()      // -> return: OptionalDouble
                .ifPresent(System.out::println);
        System.out.println();

        // Transferir dados de arquivos para streams:

        try(
                Stream<String> lines = Files.lines(Paths.get("flu.txt"))
                ){

            lines.forEach(s -> System.out.println(s.toUpperCase()));

        }catch(IOException e){
            e.printStackTrace();
        }






    }
}
