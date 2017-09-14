package src.com.bjpowernode.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类TimerTest.java的实现描述：定时器
 * 
 * @author Administrator 2017年8月17日 上午9:04:59
 */
public class TimerTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    public static void main(String[] args) {
        String timingTime = "2017-08-17 13:21:00 000";// 定时执行时间
        Long timeInterval = 10 * 1000L;// 时间间隔多长时间执行一次

        Timer t = new Timer();
        try {
            t.schedule(new LogTimerTask(), sdf.parse(timingTime), timeInterval);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

/**
 * 类TimerTest.java的实现描述：执行任务
 * 
 * @author Administrator 2017年8月17日 下午12:52:54
 */
class LogTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("测试定时器：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
    }

}
