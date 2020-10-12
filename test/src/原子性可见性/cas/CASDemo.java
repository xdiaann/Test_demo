package 原子性可见性.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MR.Z
 * @date 2020/10/6 18:40
 */
public class CASDemo {


    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2020) + "  current date is" + atomicInteger);

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "  current date is" + atomicInteger);

    }
}
