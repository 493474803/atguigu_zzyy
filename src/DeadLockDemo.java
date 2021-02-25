import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+ "自己持有"+lockA+" 尝试获得"+lockB);


            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"自己持有"+lockB+"尝试获得"+lockA);
            }
        }
    }
}
/**
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因为争夺资源而造成的一种等待现象
 * 若无外力干涉 那他们都将无法推进下去
 * **/
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();

        /**
         * linux ps -ef|grep xxx
         * windows 下的java运行程序  类似 ps 的查看进程的命令 ， 但目前我们需要查看的只是java进程
         *      jps = Java ps    jps -l  类似 ls
         *      jps 定位java进程号
         *      jstack 找到死锁线程查看
         * **/
    }
}
