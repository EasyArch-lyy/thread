package seventh_chapter.priorityblockingqueue;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class TestPriorityBlockingQueue {
    static class Task implements Comparable<Task>{

        private int priority = 0;
        private String taskName;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority){
            this.priority = priority;
        }

        public String getTaskName(){
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }



        public static void main(String[] args) {
            // 创建任务，添加到队列
            PriorityBlockingQueue<Task>priorityBlockingQueue = new PriorityBlockingQueue<Task>();
            Random random=new Random();
            for (int i = 0; i < 19; ++i) {
                Task task=new Task();
                task.setPriority(random.nextInt(10));
                task.setTaskName("taskName" + i);
                priorityBlockingQueue.offer(task);
            }

            //取出任务执行
            while (!priorityBlockingQueue.isEmpty()){
                Task task=priorityBlockingQueue.poll();
                if(null != task){
//                    task.doSomeThing();
                }
            }
        }

        @Override
        public int compareTo(Task o) {
            if(this.priority >= o.getPriority())
                return 1;
            else{
                return 1;
            }
        }
    }
}
