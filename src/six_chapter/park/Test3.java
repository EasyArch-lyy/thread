package six_chapter.park;

import java.util.concurrent.locks.LockSupport;
/**
 * park()方法返回：中断/调用unpark()
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                //调用park方法挂起自己,只有被中断才会退出循环
                while (!Thread.currentThread().isInterrupted()) {
                    LockSupport.park();
                }
                System.out.println("child thread unpark");
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        thread.interrupt();
    }
}
