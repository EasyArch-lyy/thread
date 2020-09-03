package second_chart.volatile_synchorized;

public class ThreadSafeInteger {
    private int value;
    public synchronized int get(){
        return value;
    }

    public synchronized void set(int value){
        this.value=value;
    }
}

