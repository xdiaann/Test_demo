package 其他;

public class MaxMemory_totalMemory {
    public static void main(String[] args) {
        long maxMemory=Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();


        System.out.println("最大内存的4分之一="+maxMemory+"(字节)="+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("java虚拟机中内存容量64分之一="+totalMemory+"(字节)="+(totalMemory/(double)1024/1024)+"MB");

       /* String str="xccjs";
       //专门产生垃圾
        while (true){
            str += str + new Random().nextInt(888888)+new Random().nextInt(888888);
        }*/
    }
}
