package src.com.bjpowernode.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface valueField {
    String value() default "";

    int intValue() default 0;

    boolean booleanValue() default false;

    long longValue() default 0L;
    
    String formate() default "yyyy-MM-dd HH:mm:ss";
}
