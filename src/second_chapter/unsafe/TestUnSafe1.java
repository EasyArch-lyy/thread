package second_chapter.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 反射获取unsafe
 */
public class TestUnSafe1 {

    static Unsafe unsafe;
    static long stateOffset;
    private volatile long state = 0;

    static {
        try {
            // 使用反射获取Unsafe成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe = (Unsafe) field.get(null);
            //获取state在TestUnsafe1中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnSafe1.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnSafe1 test = new TestUnSafe1();
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
