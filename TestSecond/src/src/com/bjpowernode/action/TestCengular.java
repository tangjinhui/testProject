package src.com.bjpowernode.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import src.com.bjpowernode.entity.Student;

import com.alibaba.fastjson.JSON;

public class TestCengular {

    private Date startPoolCreate;
    private Date endPoolCreate;

    public static void main(String[] args) {
        String str = "{\"id\": \"63159\", \"member_id\": \"4lb18435\",\"company_name\": \"无锡市标之龙金属制品有限公司\", \"type\": \"1\",\"pool_create\": \"1499647813000 \",\"pool_status\": \"1\",\"status\": \"0\",\"follow_person\": \"null\",\"clm_pool_id\": \"46878\",\"identity\": \"\",\"location\": \"\",\"label\": \"\",\"index_name\": \"clm\"}";
        /**
         * 日期加60天，第一种用法：
         */
        DateFormat strToDate3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createSTR = "2017-05-10 12:10:20";
        Date create = new Date();
        try {
            create = strToDate3.parse(createSTR);
        } catch (ParseException e) {
            System.out.println("日期转化异常");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(create);
        System.out.println("创建时间：" + strToDate3.format(calendar.getTime()));// 今天的日期
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 60);// 让日期加1
        System.out.println("加了60天后：" + strToDate3.format(calendar.getTime()));// 加1之后的日期Top
        if (new Date().after(calendar.getTime())) {
            System.out.println("小于");
        } else {
            System.out.println("大于");
        }
        String showId = getShowId(1L, new Date());
        System.out.println(showId);

        Student person = new Student();

        /**
         * 日期加60天，第二种用法：
         */
        person.setBirthday(DateUtils.addDays(new Date(), 60));
        System.out.println(DateUtils.addDays(new Date(), 60));

        System.out.println("person" + JSON.toJSON(person));
    }

    public static String getShowId(Long projectId, Date createTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        String year = dateFormat.format(createTime);
        return "hs" + year + String.format("%06d", projectId);
    }

    private static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        now.set(Calendar.HOUR_OF_DAY, 0);
        // 设置每小时最大分钟
        now.set(Calendar.MINUTE, 0);
        // 设置每分钟最大秒
        now.set(Calendar.SECOND, 0);
        return now.getTime();
    }

    public Date getStartPoolCreate() {
        return startPoolCreate;
    }

    public void setStartPoolCreate(Date startPoolCreate) {
        if (startPoolCreate == null) {
            this.startPoolCreate = startPoolCreate;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startPoolCreate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
            calendar.set(Calendar.HOUR, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            this.startPoolCreate = calendar.getTime();
        }

    }

    public Date getEndPoolCreate() {
        return endPoolCreate;
    }

    public void setEndPoolCreate(Date endPoolCreate) {

        if (endPoolCreate == null) {
            this.endPoolCreate = endPoolCreate;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endPoolCreate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
            this.endPoolCreate = calendar.getTime();
        }
    }

}
