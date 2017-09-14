package src.com.bjpowernode.action;

import org.springframework.beans.factory.InitializingBean;

public class TestInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 测试");

    }

    private static void testInit() {
        System.out.println("init");
    }

    public static void main(String[] args) {
    }
}
