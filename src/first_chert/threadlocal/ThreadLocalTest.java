package first_chert.threadlocal;
//
//public class ThreadLocalTest {
//    //创建ThreadLocal变量
//    static ThreadLocal<String>localVariable = new ThreadLocal<>();
//    //print函数
//    static void print(String str) {
//        System.out.println(str+":"+lcoalVariable.get);
//    }
//
//    public static void main(String[] args) {
//        Thread threadOne = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //设置线程One中本地变量localVariable的值
//                localVariable.set("threadOne local variable");
//                //调用打印函数
//                print("threadOne");
//                //打印本地变量值
//                System.out.println("threadOne remove after"+":"+localVariable.get());
//            }
//        });
//        Thread threadTwo = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //设置线程Two中本地变量中localVariable的值
//                localVariable.set("threadTwo lcoal variable");
//                //调用打印函数
//                print("threadTwo");
//                System.out.println("threadTwo remove after"+":"+localVariable.get());
//            }
//        });
//        //启动线程
//        threadOne.start();
//        threadTwo.start();
//    }
//}
