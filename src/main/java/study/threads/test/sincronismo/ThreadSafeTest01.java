package study.threads.test.sincronismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OnlyListIsThreadSafe {

    // Nossa lista de nomes foi criada sendo THREAD SAFE
    private List<String> names = Collections.synchronizedList(new ArrayList<>());

    public void add(String name) {
        names.add(name);
    }

    public void removeFirst() {
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }

}

class ExternalMethodsIsThreadSafe {

    // Nossa lista de nomes foi criada sendo THREAD SAFE
    private List<String> names = Collections.synchronizedList(new ArrayList<>());

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void removeFirst() {
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }

}

public class ThreadSafeTest01 {
    public static void main(String[] args) {


//      -------------- Primeiro exemplo onde foi criada uma classe
//      com uma lista thread safe como atributo mas os métodos não thread safe
        OnlyListIsThreadSafe onlyListIsThreadSafe = new OnlyListIsThreadSafe();
        // Adicionado na lista thread safe o nome
        onlyListIsThreadSafe.add("PH Ganso");


//      -------------- Segundo exemplo onde foi criada uma classe
//      com uma lista thread safe como atributo e os
//      métodos TAMBÉM sendo thread safe
        ExternalMethodsIsThreadSafe externalMethodsIsThreadSafe = new ExternalMethodsIsThreadSafe();
        externalMethodsIsThreadSafe.add("Nino");


        //  *** Trocar a classe que chama o método em Runnable ***

        // Startando duas threads que vão tentar excluir dessa
        // lista(thread safe) um elemento
        Runnable r = onlyListIsThreadSafe::removeFirst;
        new Thread(r).start();
        new Thread(r).start();


        /*######################################################
            Com o resultado percebemos que não basta a classe
            que está sendo chamada ser thread safe, os métodos
            externos devem ser tb
        #########################################################*/


    }
}
