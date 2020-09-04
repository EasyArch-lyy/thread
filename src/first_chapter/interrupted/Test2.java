package first_chapter.interrupted;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadOne begin sleep for 2000000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    return;
                }
                System.out.println("threadOne-leaving normally");
            }
        });
        //启动线程
        threadOne.start();
        //主线程休眠（确保子线程休眠）
        Thread.sleep(1000);
        //打断子线程休眠，让子线程从sleep函数返回
        threadOne.interrupt();
        //等待子线程执行完毕
        threadOne.join();
        System.out.println("main thread is over");
    }
}
