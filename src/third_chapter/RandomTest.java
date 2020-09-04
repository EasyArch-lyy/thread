package third_chapter;

import java.util.Random;

/**
 * 随机数生成类
 */
public class RandomTest {
    public static void main(String[] args) {
        // 创建默认种子的随机数生成器
        Random random = new Random();
        // 输出10个0~5(不包括5)之间的随机数
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(5));
        }
    }
}
//{SSHA}e4gHnvgKzkr27SpHwvN04ltemGt2z7rU
