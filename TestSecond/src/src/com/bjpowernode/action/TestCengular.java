package src.com.bjpowernode.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import src.com.bjpowernode.entity.Person;
import src.com.bjpowernode.entity.Student;

public class TestCengular {
    public static void main(String[] args) {
       /**
        * 日期加60天，第一种用法：
        */
        DateFormat strToDate3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createSTR = "2017-05-10 12:10:20";
        Date create = new Date();
        try {
            try {
                create = strToDate3.parse(createSTR);
            } catch (java.text.ParseException e) {
                // TODO Auto-generated catch block
            }
        } catch (ParseException e) {
            System.out.println("日期转化异常");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(create);
        System.out.println("创建时间：" + strToDate3.format(calendar.getTime()));//今天的日期
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 60);//让日期加1  
        System.out.println("加了60天后：" + strToDate3.format(calendar.getTime()));//加1之后的日期Top 
        if(new Date().after(calendar.getTime())){
            System.out.println("小于");
        }else{
            System.out.println("大于");
        }
        String showId = getShowId(1L,new Date());
        System.out.println(showId);
        
        Student person = new Student();
        
         /**
         * 日期加60天，第二种用法：
         */
        person.setBirthday(DateUtils.addDays(new Date(), 60));
        System.out.println(DateUtils.addDays(new Date(), 60));
        
        System.out.println("person"+JSON.toJSON(person));
    }
    
    
    public static String getShowId(Long projectId, Date createTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        String year = dateFormat.format(createTime);
        return "hs" + year + String.format("%06d", projectId);
    }
   
}


