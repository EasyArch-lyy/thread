package second_chart.volatile_synchorized;

public class ThreadSafeInteger2 {
    private volatile int value;
    public int get(){
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
