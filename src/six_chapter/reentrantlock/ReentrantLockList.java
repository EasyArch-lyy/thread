package six_chapter.reentrantlock;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个线程安全list
 * 多个线程尝试获取独占锁，获取不到的转换成node节点被放入ReentrantLock对应的AQS阻塞队列然后挂起
 */
public class ReentrantLockList {

    //线程不安全的list
    private ArrayList<String> arrayList = new ArrayList<String>();
    //独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    public void add(String e){
        lock.lock();
        try{
            arrayList.add(e);
        } finally {
            lock.unlock();
        }
    }
    //删除元素
    public void remove(String e){
        lock.lock();
        try{
            arrayList.remove(e);
        }finally {
            lock.unlock();
        }
    }
    //获取元素
    public String get(int index){
        lock.lock();
        try{
            return arrayList.get(index);
        }finally {
            lock.unlock();
        }
    }
}
