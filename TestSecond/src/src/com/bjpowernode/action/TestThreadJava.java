package src.com.bjpowernode.action;

import src.com.bjpowernode.entity.MyObject;


public class TestThreadJava{
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
       
        try {
            TestThread thread = new TestThread();
            thread.start();
            thread.sleep(1);
            thread.setRunninng(false);
            TestThread1 thread1 = new TestThread1();
            thread1.start();
            thread1.sleep(1);
            thread1.setRunninng(false);
            TestThread2 thread2 = new TestThread2();
            thread2.start();
            thread2.sleep(1);
            thread2.setRunninng(false);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
class TestThread2 extends Thread {
    private boolean isRunninng = true;
   
    
    public boolean isRunninng() {
        return isRunninng;
    }
    public void setRunninng(boolean isRunninng) {
        this.isRunninng = isRunninng;
    }
    
    @Override
    public void run() {
       System.out.println("run2 方法 start");
       int count =0;
       while(isRunninng==true){
           System.out.println("2循环中..."+count++);
           
       }
       System.out.println("run2 执行结束！");
        
    }
}
class TestThread1 extends Thread {
    private boolean isRunninng = true;
   
    
    public boolean isRunninng() {
        return isRunninng;
    }
    public void setRunninng(boolean isRunninng) {
        this.isRunninng = isRunninng;
    }
    
    @Override
    public void run() {
       System.out.println("run1 方法 start");
       int count =0;
       while(isRunninng==true){
           System.out.println("1循环中..."+count++);
           
       }
       System.out.println("run1 执行结束！");
        
    }
}
class TestThread extends Thread {
    private boolean isRunninng = true;
   
    
    public boolean isRunninng() {
        return isRunninng;
    }
    public void setRunninng(boolean isRunninng) {
        this.isRunninng = isRunninng;
    }
    
    @Override
    public void run() {
       System.out.println("run 方法 start");
       int count =0;
       while(isRunninng==true){
           System.out.println("循环中..."+count++);
           
       }
       System.out.println("run 执行结束！");
        
    }
}

/**
 * 线程间的通信方式

    ①同步
    
            这里讲的同步是指多个线程通过synchronized关键字这种方式来实现线程间的通信。
 * 类TestThreadJava.java的实现描述：TODO 类实现描述 
 * 
 * @author Administrator 2017年7月6日 下午5:33:51
 */



class ThreadA extends Thread {

    private MyObject object;
//省略构造方法
    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadB extends Thread {

    private MyObject object;
//省略构造方法
    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}

 class Run {
    public static void main(String[] args) {
        MyObject object = new MyObject();

        //线程A与线程B 持有的是同一个对象:object
//        ThreadA a = new ThreadA(object);
//        ThreadB b = new ThreadB(object);
//        a.start();
//        b.start();
    }
}
