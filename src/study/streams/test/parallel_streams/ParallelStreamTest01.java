package study.streams.test.parallel_streams;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamTest01 {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 100_000_000;

        // Usando o for convencional
        usingFor(num);

        // Usando o Stream interate
        usingStreamIterate(num);
        // com parallel
        usingParallelStreamIterate(num);

        //Usando o LongStream
        usingLongStreamIterate(num);
        // com parallel
        usingParallelLongStreamIterate(num);

    }

    private static void usingFor(long num){

        methodName();
        long result = 0;
        long init = System.currentTimeMillis();
        for( int i = 0 ; i < num ; i++){
            result += i;
        }
        long end = System.currentTimeMillis();

        System.out.println(result + " -> "+(end - init)+"ms");

    }

    private static void usingStreamIterate(long num){

        methodName();
        long init = System.currentTimeMillis();
        long result = Stream
                .iterate(0L, n -> n+1)
                .limit(num)
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " -> "+(end - init)+"ms");

    }

    private static void usingParallelStreamIterate(long num){

        methodName();
        long init = System.currentTimeMillis();
        long result = Stream
                .iterate(0L, n -> n+1)
                .parallel()
                .limit(num)
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " -> "+(end - init)+"ms");

    }

    private static void usingLongStreamIterate(long num){

        methodName();
        long init = System.currentTimeMillis();
        long result = LongStream
                .rangeClosed(1L, num)
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " -> "+(end - init)+"ms");

    }

    private static void usingParallelLongStreamIterate(long num){

        methodName();
        long init = System.currentTimeMillis();
        long result = LongStream
                .rangeClosed(1L, num)
                .parallel()
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " -> "+(end - init)+"ms");

    }

    private static void methodName(){

        Throwable thr = new Throwable();
        thr.fillInStackTrace();
        StackTraceElement[] ste = thr.getStackTrace();
        System.out.println("Método ["+ste[1].getMethodName()+"()]: ");

    }



}
