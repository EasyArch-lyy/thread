package six_chapter.park;

import java.util.concurrent.locks.LockSupport;

/**
 * 根据blocker排查线程阻塞原因
 */
public class TestPark {

    public void testPark() {
        LockSupport.park();
    }

    public static void main(String[] args) {

        TestPark testPark = new TestPark();
        testPark.testPark();
    }
}
