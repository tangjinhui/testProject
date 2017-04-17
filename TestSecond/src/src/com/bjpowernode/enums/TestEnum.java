package src.com.bjpowernode.enums;

import java.util.HashMap;
import java.util.Map;
public enum TestEnum {
    NAN(1,"男"),
    NV(2,"女");
    
    private Integer code;
    private String  name;
    
    TestEnum(Integer code,String name){
        this.setCode(code);
        this.setName(name);
    }
    private static final Map<Integer, TestEnum> map = new HashMap<Integer, TestEnum>();

    static {
        for (TestEnum value : TestEnum.values()) {
            map.put(value.getCode(), value);
        }
    }
    public  static TestEnum getEnum(Integer code){
        return map.get(code);
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
