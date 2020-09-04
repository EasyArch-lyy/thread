package first_chapter.wait_nodify;

public class Test2 {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取resourceA共享资源监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");
                        // 获取resourceB共享资源监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");
                            System.out.println("threadA release resourceA lock");
                            // 线程A阻塞，释放获取到的resourceA的锁
                            // wait()只会释放当前共享对象的锁，当前线程持有其他共享对象的锁不回被释放
                            resourceA.wait();
                        }
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    // 获取resourceA共享资源监视器锁
                    synchronized (resourceA){
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock...");
                        synchronized (resourceB){
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 启动线程
        threadA.start();
        threadB.start();
        // 等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}
