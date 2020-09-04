package first_chapter.create_thread;

/**
 * 线程创建
 */
public class ThreadTest1 {
    //继承Thread并重写run
    //run()获取当前线程直接使用this，无需Thread.currentThread()
    public static class MyThread extends Thread {
        public void run(){
            System.out.println("I am a child thread");
        }
    }
    public static void main(String[] args) {
        //创建线程
        //创建完后未立刻执行，就绪状态，线程获得除CPU外其他资源，获取CPU进入运行状态
        MyThread thread = new MyThread();
        //启动线程
        thread.start();
    }
}
