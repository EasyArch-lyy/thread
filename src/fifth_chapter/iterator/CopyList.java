package fifth_chapter.iterator;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * 获取迭代器操作必须在子线程操作之前
 */
public class CopyList {
    private static volatile CopyOnWriteArrayList<String>arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("ssdads");
        arrayList.add("asdfasdf");
        arrayList.add("asdfasdfas");
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1,"alibaba");
                arrayList.remove(2);
            }
        });

        //保证在修改线程启动前获取迭代器
        Iterator<String>itr = arrayList.iterator();
        threadOne.start();
        threadOne.join();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
