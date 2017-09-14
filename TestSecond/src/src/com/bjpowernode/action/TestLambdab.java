package src.com.bjpowernode.action;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

import com.alibaba.fastjson.JSON;

/**
 * 类TestLambdab.java的实现描述：java8新特性
 * 
 * @author tangjinhui 2017年7月28日 上午10:08:10
 */
public class TestLambdab {

    public static void main1(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello world");

            }
        };
        Runnable r2 = () -> System.out.print("hello world");

        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                // TODO Auto-generated method stub
                return Integer.compare(arg0.length(), arg1.length());
            }

        });

        TreeSet<String> treeSet2 = new TreeSet<>((arg0, arg1) -> Integer.compare(arg0.length(), arg1.length()));

        Consumer<String> con2 = new Consumer<String>() {

            @Override
            public void accept(String arg0) {
                System.out.println(arg0);

            }

        };
        Consumer<String> con = x -> System.out.println(x);
        con.accept("ceshi");

        Comparator<Integer> comparator = (x2, x3) -> Integer.compare(x2, x3);

    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello world");

            }
        };
        r.run();
        Runnable r2 = () -> System.out.print("hello world");
        r2.run();
        // String str12 = toUpperCaseStr((str) -> str.,str:"dongna");
        // System.out.println(str12);
        List<String> names = Arrays.asList("a", "c", "y", "s", "t");
        Collections.sort(names, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                // TODO Auto-generated method stub
                return a.compareTo(b);
            }

        });
        System.out.println(JSON.toJSONString(names));

        List<String> name = Arrays.asList("asdf", "csdfsadf", "sdfafy", "sdaffs", "sdafdfdt");
        Collections.sort(name, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                // TODO Auto-generated method stub
                return Long.compare(a.length(), b.length());
            }

        });

        Collections.sort(name, (String a, String b) -> Long.compare(b.length(), a.length()));

        System.out.println(JSON.toJSONString(name));
    }

    public static String toUpperCaseStr(MyFun<String> mf, String str) {
        return mf.getValue(str);
    }

}
