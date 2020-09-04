package fifth_chapter;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * 迭代器弱一致性
 * 迭代器遍历的是数组的一个快照（获取迭代器后其他线程对list的修改是不可见的）
 */
public class CopyList {
    private static volatile CopyOnWriteArrayList<String>arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //修改list中下标为1的元素为baba
                arrayList.set(1, "baba");
                //删除元素
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });

        //保证在修改线程启动前获取迭代器
        Iterator<String>itr = arrayList.iterator();

        //启动线程
        threadOne.start();
        //等待子线程执行完毕
        threadOne.join();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
