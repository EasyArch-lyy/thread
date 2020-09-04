package first_chapter.wait_nodify;
/**
 * notify注意事项
 */
public class Test3 {

    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA){
                    System.out.println("threadA get resourceA lock");
                    try{
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //创建线程
        Thread threadC =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    System.out.println("threadC begin notify");
                    resourceA.notify();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
//Plugin is missing: workflow-step-api (2.16)
//Plugin is missing: scm-api (2.2.6)
//Plugin is missing: structs (1.17)
