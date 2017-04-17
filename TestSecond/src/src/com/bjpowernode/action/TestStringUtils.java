package src.com.bjpowernode.action;

import org.apache.commons.lang.StringUtils;

/**
 * 类TestStringUtils.java的实现描述：TODO 类实现描述
 * 
 * StringUtils的用法，对数组直接转为需要的字符串
 * 
 * @author tangjinhui 2017年3月31日 下午5:43:57
 */
public class TestStringUtils {
    public static void main(String[] args) {
        String[] s;
        int i;
        s = new String[5];
        for (i = 0; i < 5; i++) {
            s[i] = i + "";
        }
        String join = StringUtils.join(s, ",");
        System.out.println(join);
    }

}
