package second_chapter.cache;
/**
 * 解决伪共享
 */
public class Test {
    //手动填充
    public final static class FilledLong1 {
        public volatile long value = 0L;
        public long p1,p2,p3,p4,p5,p6;
    }

    //JDK8提供注解填充
    @sun.misc.Contended
    public final static class FilledLong2 {
        public volatile long value = 0L;
    }
}
