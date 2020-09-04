package first_chapter.create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest3 {
    //创建任务类
    public static class CallerTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try{
            //等待任务执行完毕，返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
