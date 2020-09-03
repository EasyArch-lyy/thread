package first_chert.threadlocal;
/**
 * threadLocal不具有继承性(父线程设置后子线程获取不到)
 */
public class TestThreadLocal {

    //创建线程变量
//    public static ThreadLocal<String>threadLocal = new InheritableThreadLocal<String>();
    public static ThreadLocal<String>threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        //设置线程变量
        threadLocal.set("hello world");

        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thead:"+ threadLocal.get());
            }
        });
        thread.start();
        //主线程输出线程变量的值
        System.out.println("main:"+threadLocal.get());
    }
}
