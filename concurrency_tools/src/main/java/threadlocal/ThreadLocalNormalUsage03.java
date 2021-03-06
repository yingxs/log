package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000个线程打印日期的任务，用线程池执行
 */
public class ThreadLocalNormalUsage03 {



    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");



    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {

                    String date = new ThreadLocalNormalUsage03().dete(finalI);
                    System.out.println(date);
                }
            });

        }
        threadPool.shutdown();



    }
    public String dete (int seconds) {
        Date date = new Date(1000 * seconds);

        return dateFormat.format(date);
    }

}
