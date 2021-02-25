
/**
 * jps 查看java后台进程
 * jinfo -flag 配置参数 查看java 后台信息
 *      + 表示开启  - 表示关闭
 *  参数： XX : +PrintGCDeatils 开启打印GC收集细节
 *             +UseSerialGC  是否使用串行垃圾回收
 *
 *             MetespaceSize 元空间大小
 *             MaxTenuringThreshold  默认分代最大年龄
 *
 *             -Xms 1024m  =  等价于 -XX:InitialHeapSize 初始堆内存
 *             -Xmx 1024m  =  等价于 -XX:MaxHeapSize   最大堆内存
 *
 * java -XX: +PrintFlagsInitial 如何查看jvm 初始参数
 * java -XX: +PrintFlagsFinal -version 查看修改后得参数
 * **/
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("helloGC");

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
