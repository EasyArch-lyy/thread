package third_chapter;

import java.util.concurrent.ThreadLocalRandom;

public class RandomTest1 {
    public static void main(String[] args) {
        //获取当前线程的所及数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i=0;i<10;++i){
            System.out.println(random.nextInt(5));
        }
    }
}
