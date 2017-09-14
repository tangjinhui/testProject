package src.com.bjpowernode.action;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 类TestStringUtils.java的实现描述：TODO 类实现描述 StringUtils的用法，对数组直接转为需要的字符串
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

        String str = "服务、";
        str.length();
        str.substring(1, str.length() - 1);
        System.out.println(str.substring(0, str.length() - 1));
        System.out.println(str.length());
        String str2 = "";
        StringBuffer sb = new StringBuffer();
        System.out.println("->" + String.valueOf(sb) + "<-");
        System.out.println("".equals(String.valueOf(sb)) == true ? true : false);

        double rate = 0.00;
        try {
            double div = div(Double.valueOf(rate), Double.valueOf(4.00), 2);
            System.out.println(div);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rate = 1.00;
        System.out.println(rate == 0.00 ? 0.00 : rate / 4.00);

        String strb = "{\"searchtime\":0.038538,\"total\":44812,\"num\":10,\"viewtotal\":5000,\"items\":[{\"member_id\":\"4lu1zarx\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"2\",\"clm_pool_id\":\"44935\",\"identity\":\"\",\"company_name\":\"东莞市正荭不锈钢有限公司\",\"pool_create\":\"1500292511000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45082\",\"follow_person\":\"bp-anerde|安二的\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1an3w\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44934\",\"identity\":\"\",\"company_name\":\"佛山市顺德区源腾贸易有限公司\",\"pool_create\":\"1500292506000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45081\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1an32\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44933\",\"identity\":\"\",\"company_name\":\"潍坊市誉恒钢铁贸易有限公司\",\"pool_create\":\"1500292501000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45080\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1zars\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44931\",\"identity\":\"\",\"company_name\":\"济南齐鑫特钢有限公司\",\"pool_create\":\"1500292495000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45078\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1an3z\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44932\",\"identity\":\"\",\"company_name\":\"佛山市顺德区合达信钢铁有限公司\",\"pool_create\":\"1500292489000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45079\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1a8t6\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44930\",\"identity\":\"\",\"company_name\":\"阿波罗测试公司19755555221\",\"pool_create\":\"1500261809000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45077\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1a6i6\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44929\",\"identity\":\"\",\"company_name\":\"阿波罗测试公司19755555220\",\"pool_create\":\"1500261804000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45076\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1a8tb\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44928\",\"identity\":\"\",\"company_name\":\"阿波罗测试公司19755555219\",\"pool_create\":\"1500261798000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45075\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1app8\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44927\",\"identity\":\"\",\"company_name\":\"阿波罗测试公司19755555218\",\"pool_create\":\"1500261793000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45074\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"},{\"member_id\":\"4lu1a6ib\",\"mobile\":\"\",\"label\":\"\",\"type\":\"1\",\"search_type\":\"1\",\"clm_pool_id\":\"44926\",\"identity\":\"\",\"company_name\":\"阿波罗测试公司19755555217\",\"pool_create\":\"1500261788000\",\"pool_status\":\"1\",\"location\":\"\",\"id\":\"45073\",\"follow_person\":\"\",\"index_name\":\"clm\",\"status\":\"1\"}],\"facet\":[]}";
        System.out.println(JSON.parseObject(strb));

        String anyStr = "|公司名称|公司域名|姓名|手机号|座机|邮箱|传真|区域|省份|城市|地址|经营模式|公司介绍|性别|主营产品|会员类型|Nothing";
        String[] split = anyStr.split("|");
        for (String string : split) {
            System.out.println("string:" + string);
        }

    }

    /**
     * 提供精确加法计算的add方法
     * 
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     * 
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     * 
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的除法运算方法div
     * 
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double div(double value1, double value2, int scale) throws IllegalAccessException {
        // 如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.divide(b2, scale).doubleValue();
    }
}
