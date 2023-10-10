package study.concorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {

    private final Map<Integer, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rwl;

    public MapReadWrite(ReentrantReadWriteLock rwl){
        this.rwl = rwl;
    }

    public void put(Integer i){
        rwl.writeLock().lock();
        try{

            if(rwl.isWriteLocked()){
                System.out.printf("O recurso está travado para leitura e escrita pela Thread %s%n",Thread.currentThread().getName());
            }
            Thread.sleep(500);
            map.put(i, "Valor nº" + i);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Map<Integer, String> retrieveAll(){

        Map<Integer, String> mapToReturn;
        rwl.readLock().lock();
        try{

            mapToReturn = new LinkedHashMap<>(this.map);
            return mapToReturn;

        }finally {
            rwl.readLock().unlock();
        }
    }

}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mrw = new MapReadWrite(rwl);

        Runnable writer = () -> {
            for (int i = 0; i < 5; i++) {
                mrw.put(i);
            }
        };

        Runnable reader = () -> {


            if (rwl.isWriteLocked()) {
                System.out.println("WRITE LOCKED!");
            }

            rwl.readLock().lock();
            System.out.println("FINALLY I GOT THE DAMN LOCK");
            try {
                System.out.println(Thread.currentThread().getName() + " " + mrw.retrieveAll());
            } finally {
                rwl.readLock().unlock();
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);
        t1.start();
        t2.start();
        t3.start();

    }
}
