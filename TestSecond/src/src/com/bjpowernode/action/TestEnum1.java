package src.com.bjpowernode.action;

import java.util.HashMap;
import java.util.Map;

public enum TestEnum1 {
    COMMON_MEMBER("会员", 1), REALNAME_MEMBER("实名会员", 2), TRADE_MEBER("交易会员", 3);

    private Integer code;
    private String  desc;

    TestEnum1(String desc, Integer code){
        this.setCode(code);
        this.setDesc(desc);
    }

    public static void main(String[] args) {
        Integer code1 = 1;
        Integer code2 = 2;
        Integer code3 = 3;

        String desc1 = TestEnum1.getEnum(code1).getDesc();
        String desc2 = TestEnum1.getEnum(code2).getDesc();
        String desc3 = TestEnum1.getEnum(code3).getDesc();
        System.out.println(desc1);
        System.out.println(desc2);
        System.out.println(desc3);

        // ===========================
        Integer code4 = TestEnum1.COMMON_MEMBER.getCode();
        String desc4 = TestEnum1.COMMON_MEMBER.getDesc();
        Integer code5 = TestEnum1.REALNAME_MEMBER.getCode();
        String desc5 = TestEnum1.REALNAME_MEMBER.getDesc();
        Integer code6 = TestEnum1.TRADE_MEBER.getCode();
        System.out.println(code4);
        System.out.println(code5);
        System.out.println(code6);

        System.out.println(desc4);
        System.out.println(desc5);

    }

    private static Map<Integer, TestEnum1> map = new HashMap<>();

    static {

        for (TestEnum1 value : TestEnum1.values()) {
            map.put(value.getCode(), value);
        }
    }

    public static TestEnum1 getEnum(Integer code) {
        return map.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
