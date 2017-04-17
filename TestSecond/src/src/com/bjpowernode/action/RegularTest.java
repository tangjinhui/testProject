package src.com.bjpowernode.action;

import java.util.regex.Pattern;

public class RegularTest {
    //数据源
   private static  String                      str             = "1234567890123.00";

    private static final String formatSpecifier = "^([1-9](?:\\d{12}\\.\\d{2}|\\d{12})+\\.[0-9]{1,2})$";
    //正则模板：编译
    private static Pattern      fsPattern       = Pattern.compile(formatSpecifier);
    
    private static void parse(String s) {
        //校验数据格式，是否满足正则表达式
        boolean matches =fsPattern.matcher(s).matches();
        System.out.println( matches);
    }
    public static void main(String[] args) {
        parse(str);
    }
}
