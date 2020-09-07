package six_chapter.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 条件变量
 */
public class Test {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        //相当与进入synchorized
        lock.lock();
        try {
            System.out.println("begin wait");
            //阻塞挂起当前线程(等待其他线程调用signal时阻塞线程从await()返回)
            condition.await();
            System.out.println("end wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放获取的锁
            lock.unlock();
        }
    }
}
