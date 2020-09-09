package data_struct;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 特殊的线性表，只允许再队列前端删除操作，表的后端进行插入操作
 * LindedList实现了Queue接口，可以将LinkedList当Queue使用
 */
public class Main_Queue {
    public static void main(String[] args) {
        //add和remove再失败时会抛出异常(不推荐使用)
        Queue<String>queue = new LinkedList<String>();
       /**
        * offer，add 区别：
        * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
        * 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
        * poll，remove 区别：
        * remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
        * peek，element区别：
        * element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
        */
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        for (String q : queue) {
            System.out.println(q);
        }
        //返回第一个元素并在队列删除
        System.out.println("poll="+queue.poll());
        //返回第一个元素
        System.out.println("element="+queue.element());
        for(String q: queue){
            System.out.println(q);
        }
        //返回第一个元素
        System.out.println("peek="+queue.peek());
    }
}
