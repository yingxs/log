package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {


    public static void main(String[] args) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
        // 五秒后执行
        //        threadPool.schedule(new Task(),5, TimeUnit.SECONDS);
        // 刚开始一秒后执行一次，然后每隔三秒执行一次
        threadPool.scheduleAtFixedRate(new Task(),1,3,TimeUnit.SECONDS);


    }


}
