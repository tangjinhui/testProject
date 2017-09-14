package src.com.bjpowernode.action;

import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import src.com.bjpowernode.interf.IHelloWorldService;

public class HelloWorldServiceClient {

    public static void main(String[] args) {
        JaxWsPortProxyFactoryBean factory = new JaxWsPortProxyFactoryBean();
        // 必须是一个接口
        factory.setServiceFeatures(IHelloWorldService.class);
        factory.setAddress("http://localhost:8080/webservice?wsdl");
        // 创建接口对象
        IHelloWorldService service = (IHelloWorldService) factory.create();
        System.out.println("[result]" + service.sayHello("hoojo"));
    }
}
