package second_chapter.unsafe;

import sun.misc.Unsafe;
/**
 * 输出：java.lang.ExceptionInInitializerError
 * 本类的加载器是AppClassLoader，rt包下需要Bootstrap加载器加载
 */
public class TestUnSafe {

    //获取UnSage的实例(2.2.1)
    static final Unsafe unsafe = Unsafe.getUnsafe();
    //记录变量state在类TestUnsafe中的偏移值
    static final long stateOffset;
    //变量（2.2.3）
    private volatile long state = 0;

    static {
        try {
            //获取state变量在类TestUnsafe中的偏移值（2.2.4）
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例并设置state值为1(2.2.5)
        TestUnSafe test = new TestUnSafe();
        //(2.2.6)
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
