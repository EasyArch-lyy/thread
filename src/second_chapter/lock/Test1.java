package second_chapter.lock;
/**
 * 可重入锁
 * 可重入锁的原理是在锁内部维护一个线程标示，
 * 用来标示该锁目前被哪个线程占用，然后关联 个计数器。
 * 一开始计数器值为 o,说明该锁没有被任何线程占用，
 * 一个钱程获取了该锁时，计数器的值会变成1，他线程再来获取该锁时会发现锁的所有者不是自己而被阻塞挂起。
 *
 * 当获取了该锁的线程再次获取锁时发现锁拥有者是自己，就会把计数器值加＋1,
 * 当释放锁后计数器值-1，当计数器值为0，锁里面的线程标示被重置为 null 这时候被
 * 阻塞的线程会被唤醒来竞争获取该锁
 */
public class Test1 {

    public synchronized void helloA(){
        System.out.println("hello a");
    }

    public synchronized void helloB(){
        System.out.println("hello b");
        helloA();
    }

    public static void main(String[] args) {
        Test1 test1=new Test1();
        test1.helloB();
    }
}
