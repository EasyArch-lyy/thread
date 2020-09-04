package first_chapter.daemon;
/**
 * 线程和守护线程区别
 */
public class Test2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){

                }
            }
        });

        //启动子线程
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
