package src.com.bjpowernode.action;

import java.lang.reflect.Field;
import java.util.Date;

import src.com.bjpowernode.annotation.valueField;
import src.com.bjpowernode.entity.Person;

public class TestAnnotation {
    public static void main(String[] args) {
        Person person = new Person();
        Field[] declaredFields = person.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(valueField.class)){
                if(field.getName().equals("age")){
                    valueField value = (valueField)field.getAnnotation(valueField.class);
                     person.setAge(Integer.valueOf(value.intValue()));
                 }
                 if(field.getName().equals("name")){
                     valueField value = (valueField)field.getAnnotation(valueField.class);
                     person.setName(value.value());
                 }
                 if(field.getName().equals("nan")){
                     valueField value = (valueField)field.getAnnotation(valueField.class);
                     person.setNan(value.booleanValue());
                 }
                 if(field.getName().equals("birthdayTest")){
                     valueField value = (valueField)field.getAnnotation(valueField.class);
                     person.setBirthdayTest(value.value());
                 }
            }
        }
        
//        System.out.println(person.toString());//Person [name=zhangsan, age=2, nan=true, birthday=null, birthdayTest=jlksdfjk]
      
    }
}
