package fifth_chapter;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * 迭代器
 */
public class Test {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("hello");
        arrayList.add("alibaba");
        Iterator<String> itr = arrayList.iterator();
        // hasNext()方法判断列表是否还有元素,next()方法返回具体元素
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
