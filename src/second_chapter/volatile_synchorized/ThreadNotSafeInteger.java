package second_chapter.volatile_synchorized;
/**
 * volatile和synchorized都解决了共享变量value内存可见性,
 * synchorized只有一个线程能调用get,其他线程阻塞,增加上下文切换开销
 * volatile不能保证原子性
 */
public class ThreadNotSafeInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
