package src.com.bjpowernode.interf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynProxy implements InvocationHandler {

    /**
     * 指明为谁做代理，target为真实角色
     */
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public MyDynProxy(Object target){
        super();
        this.target = target;
    }

    /**
     * 当代理角色的 方法被执行时，会执行这个invoke方法；当执行到MyDynProxy 中的ren
     */
    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("=================invoke=============");
        this.seeHouse();
        Object object = method.invoke(this.getTarget(), args);
        this.fee();
        return object;
    }

    /**
     * 专门生成代理角色
     * 
     * @return
     */

    public Object newTargetProxy() {
        /**
         * 1参数1：代理类的类加载器 参数2：代理类要实现的接口；中介就是代理类，实现IRent接口，可以通过target.getClass.getInterfaces获取 所有的接口。 参数3：需要传入
         * 一个InvocationHandler，传入this是MyDynProxy.
         */
        // Thread.currentThread().getContextClassLoader();
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    private void fee() {
        System.out.println("===========收费============");
    }

    private void seeHouse() {
        System.out.println("========看房========");
    }

}
