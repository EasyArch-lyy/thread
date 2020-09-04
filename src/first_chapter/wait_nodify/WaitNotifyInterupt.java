package first_chapter.wait_nodify;

public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("--begin--");
                    synchronized (obj) {
                        obj.wait();
                        // threadA调用obj的wait()阻塞后挂起
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(1000);
        System.out.println("--begin interrupt threadA--");
        threadA.interrupt();
        System.out.println("--end interrupt threadA--");
    }
}
