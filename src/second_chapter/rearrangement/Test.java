package second_chapter.rearrangement;
/**
 * 指令重排
 * 不相互依赖的语句改变顺序（先执行4123）
 */
public class Test {

    private static int num = 0;
    private static boolean ready = false;

    public static class ReadThread extends Thread {
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                if (ready){//1
                    System.out.println(num+num);//2
                }
            }
        }
    }

    public static class WriteThread extends Thread {
        public void run() {
            num = 2;     //3.
            ready = true;//4.
            System.out.println("writeThread set over...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt=new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }

}
