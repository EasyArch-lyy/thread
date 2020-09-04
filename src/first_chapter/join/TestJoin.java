package first_chapter.join;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo over");
            }
        });

        threadOne.start();
        threadTwo.start();
        System.out.println("wait all child thread over");

        threadOne.join();
        threadTwo.join();
        System.out.println("all child thread over");
    }
}
