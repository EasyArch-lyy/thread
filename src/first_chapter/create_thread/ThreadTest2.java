package first_chapter.create_thread;

public class ThreadTest2 {
    //优点：可以继承其他的类，但是任务没返回值
    public static class RunableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
