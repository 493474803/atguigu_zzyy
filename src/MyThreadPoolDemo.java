import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 实现方式 ：ThreadPoolExecutor **/
public class MyThreadPoolDemo {

    /**
     * 线程池七大参数
     * 1 核心线程数 corePoolSize
     * 2 最大线程数 maximumPoolSize
     * 3 多余线程存活时间 keepAliveTime
     * 4 时间单位 unit
     * 5 阻塞队列 BlockingQueue
     * 6 线程工厂 ThreadFactory
     * 7 拒绝策略 handler   -- 当线程池到达最大线程数量 同时阻塞队列也满了启用 {
     *                          1 AbortPolicy 默认 直接抛出 异常
     *                          2 CallerRunsPolicy
     *                          3 DiscardOldestPolicy  丢弃等待最久得任务 将当前任务加入队列
     *                          4 DiscardPolicy  直接丢弃任务 不处理 如果允许任务丢失 是最好得方案
     *                        }
    */

    /**
     *  定长线程池 单一线程池 可缓存扩容线程池 生产上使用哪个？    根据阿里巴巴手册 一个都不用
     *  原因：  FixedThreadPool 与 SingleThreadPool 的阻塞队列长度为integer最大值  可能堆积大量请求导致oom
     *  推荐手写线程池
     * */

    ////@@@

    public static void main(String[] args) {

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);  // 创建一个定长线程池 可控制最大并发数 超出得线程会在队列中等待
//            ExecutorService threadPool = Executors.newSingleThreadExecutor();  //创建一个单线程得线程池 只会用唯一工作线程执行任务 按顺序执行
            ExecutorService threadPool = Executors.newCachedThreadPool();//创建一个可缓存扩容得线程池
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute( () -> {
                    System.out.println(Thread.currentThread().getName() + "");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
