package src.com.bjpowernode.entity;

import java.io.Serializable;
import java.util.Date;

import src.com.bjpowernode.annotation.valueField;

public class Person  implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = -5432162497310923295L;

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", nan=" + nan + ", birthday=" + birthday + ", birthdayTest="
                + birthdayTest + "]";
    }
    @valueField(value="zhangsan")
    private String name;
    @valueField(intValue=2)
	private int age;
    @valueField(booleanValue=true)
	private boolean nan;
	@valueField(longValue=13L)
	private long    shenGao;
	private Date birthday;
	@valueField("jlksdfjk")
	private String birthdayTest;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getNan() {
		return nan;
	}
	public void setNan(boolean nan) {
		this.nan = nan;
	}
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getBirthdayTest() {
        return birthdayTest;
    }
    public void setBirthdayTest(String birthdayTest) {
        this.birthdayTest = birthdayTest;
    }
    public Long getShenGao() {
        return shenGao;
    }
    public void setShenGao(Long shenGao) {
        this.shenGao = shenGao;
    }
}
