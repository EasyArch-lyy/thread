package first_chapter.interrupted;
/**
 * interrupted()内部获取当前线程的中断状态，
 *
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });
        //启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadOne.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();
    }
}
