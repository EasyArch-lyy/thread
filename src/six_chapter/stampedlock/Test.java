package six_chapter.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock三种形态转换(不可重入锁)
 * jdk1.8
 */
public class Test {

    //成员变量
    private double x, y;
    //锁实例
    private final StampedLock s1 = new StampedLock();

    //写锁(排他锁)
    void move(double deltaX, double deltaY) {
        long stamp = s1.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            s1.unlockWrite(stamp);
        }
    }
    //乐观锁
    double distanceFromOrigin(){
        //尝试获取乐观锁（1）
        long stamp = s1.tryOptimisticRead();
        //将全部交量复制到方法体栈内
        double currentX = x, currentY = y;
        //(1)处获取读锁标记后，锁有没有被其他写线程排他抢占
        if(!s1.validate(stamp)){
            //如果被抢占获取一个共享读锁(悲观获取)
            stamp=s1.readLock();
            try{
                currentX = x;
                currentY = y;
            }finally {
                s1.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY){
        long stamp = s1.readLock();
        try{
            while (x ==0.0 && y ==0.0){
                long ws = s1.tryConvertToWriteLock(stamp);
                if(ws!= 0L){
                    stamp = ws;
                    x=newX;
                    y=newY;
                    break;
                }else{
                    s1.unlockRead(stamp);
                    stamp=s1.writeLock();
                }
            }
        }finally {
            s1.unlock(stamp);
        }
    }
}
