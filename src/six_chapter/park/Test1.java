package six_chapter.park;

import java.util.concurrent.locks.LockSupport;
/**
 * unpark()作用：
 * 使线程持有LockSupport类关联的许可证
 * 唤醒被park()挂起的线程
 * 线程在调用unpark()后调用park()，其立即返回
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("begin park");
        //使当前线程获取许可证
        LockSupport.unpark(Thread.currentThread());
        //再次调用park方法
        LockSupport.park();
        System.out.println("end park");
    }
}
