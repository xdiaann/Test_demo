package 尚硅谷面试.原子性可见性.cas;

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
        //输出结果
        //true  current date is2020
        //false  current date is2020
        //解析 第一个compareAndSet 预期5 是对的  所以修改成 2020
        //但是第二个compareAndSet 预期5 是错的  所以修改失败 数值还是2020
    }
}
