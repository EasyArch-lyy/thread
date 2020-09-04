package first_chapter.yield;
/**
 * 出让时间片，但线程仍在就绪状态
 */
public class YieldTest implements Runnable {

    YieldTest(){
        //创建并启动线程
        Thread t =new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() +" yield cpu...");
                //当前线程让出CPU，放弃时间片，进行下一轮调度
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
