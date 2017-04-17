package src.com.bjpowernode.action;

import java.util.Date;

public class Test {
    
    static{
        _i=1;
    }
    public static int _i=0;
    public static void main(String[] args) {
        System.out.println(_i);
//        new Student();
    }
}
class People1{
    static{
        System.out.println("父静");
    }
    {
        System.out.println("fuchushihua");
    }
    public People1(){
        System.out.println("fu gou");
    }
}
class Student1 extends People1{
    static{
        System.out.println("zi静");
    }
    {
        System.out.println("zi chushihua");
    }
    public Student1(){
        System.out.println("zi gou");
    }
   
}