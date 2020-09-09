package fifth_chapter.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 迭代器示例
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("bcd");
        coll.add("efg");
        //可以不指定类型（默认指定为Object）
        Iterator it = coll.iterator();
        //接口实现类对象
        //判断集合是否有下一个元素
        boolean b = it.hasNext();
        System.out.println(b);
        //取出集合元素
        String s = (String) it.next();
        System.out.println(s);

        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
