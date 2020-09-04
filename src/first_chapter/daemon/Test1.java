package first_chapter.daemon;

/**
 * 创建守护线程
 */
public class Test1 {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //设置为守护进程
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
