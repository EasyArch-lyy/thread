package six_chapter.aqs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

public class Test2 {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();
    final static Queue<String> queue = new LinkedBlockingQueue<String>();
    final static int queueSize = 10;

    public static void main(String[] args) {
        //创建生产者线程
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    //如果队列满则等待，while避免虚假唤醒
                    while (queue.size() == queueSize) {
                        //阻塞挂起当前线程
                        notEmpty.await();
                    }
                    //添加元素到队列
                    queue.add("ele");
                    //唤醒消费线程
                    notFull.signalAll();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        //消费者线程
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while(0 == queue.size()){
                        notFull.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
