package six_chapter.park;

import java.util.concurrent.locks.LockSupport;
/**
 * LockSupport工具类：挂起和唤醒线程
 * LockSupport与每个使用它的线程都会关联一个许可证，默认情况下调用LockSupport类方法的线程不具许可证
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                //调用park方法挂起自己(默认情况没有许可证)
                //调用park的线程拿到了与LockSupport关联的许可证，调用时马上返回
                LockSupport.park();
                System.out.println("child thread unpark");
            }
        });
        //启动子线程
        thread.start();
        //主线程休眠1s
        Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        //调用unpark方法让thread线程持有许可证,然后park方法返回
        LockSupport.unpark(thread);
    }
}
