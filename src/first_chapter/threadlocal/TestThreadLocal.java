package first_chapter.threadlocal;
/**
 * threadLocal不具有继承性(父线程设置后子线程获取不到)
 * 线程内部的存储类，可以在指定线程内存储数据，数据存储以后，只有指定线程可以得到存储数据
 *    ThreadLocal的静态内部类ThreadLocalMap为每个Thread都维护了一个数组table，
 * ThreadLocal确定了一个数组下标，而这个下标就是value存储的对应位置。
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
