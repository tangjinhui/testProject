package src.com.bjpowernode.entity;

import java.util.Date;

public class Student {
    private String  name;
    private Integer age;
    private boolean nan;
    private Date    birthday;

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
}
