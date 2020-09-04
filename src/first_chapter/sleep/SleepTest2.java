package first_chapter.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 调用线程暂时出让指定时间的执行权，期间不参加CPU调度，拥有的监视器资源持有的锁不出让
 * 睡眠过程中其他线程调用该线程的interrupt()中短了该线程，会在调sleep()的地方抛InterruptedException
 */
public class SleepTest2 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread());
                    System.out.println("child threadA is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");
                    System.out.println(Thread.currentThread());
                    Thread.sleep(10000);
                    System.out.println("child threadB is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });
        // 启动线程
        threadA.start();
        threadB.start();
    }
}
