package first_chapter.join;

public class Test2 {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run");
                for(;;){

                }
            }
        });
        // 获取主线程
        final Thread mainThread = Thread.currentThread();

        //线程二
        Thread threadTwo =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程
                mainThread.interrupt();
            }
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }

    }
}
