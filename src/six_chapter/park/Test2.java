package six_chapter.park;

import java.util.concurrent.locks.LockSupport;

/**
 * park()作用：
 * 使已经拿到与LockSupport关联许可证的线程马上返回，否则调用线程会被阻塞挂起
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("begin park");
        LockSupport.park();
        System.out.println("end park");
    }
}
