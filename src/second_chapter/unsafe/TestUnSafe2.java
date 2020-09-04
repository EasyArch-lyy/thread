package second_chapter.unsafe;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class TestUnSafe2 {

    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;

    static {
        //使用反射获取Unsafe的成员变量
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe = (Unsafe) field.get(null);
            //获取state在TestUnSafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnSafe2.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe2 test=new TestUnSafe2();
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
