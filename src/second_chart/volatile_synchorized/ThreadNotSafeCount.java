package second_chart.volatile_synchorized;

public class ThreadNotSafeCount {
    private Long value;
    public Long getCount(){
        return value;
    }
    public void inc(){
        ++value;
    }
}
