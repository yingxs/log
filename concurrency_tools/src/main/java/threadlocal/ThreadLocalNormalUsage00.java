package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个线程打印日期
 */
public class ThreadLocalNormalUsage00 {


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().dete(10);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().dete(104707);
                System.out.println(date);
            }
        }).start();
    }

    public String dete (int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
