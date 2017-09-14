package src.com.bjpowernode.interf;


public class TestDyn {

    public static void main(String[] args) {
        // ==========================方法一================================
        IRent landLord = new LandLord();

        MyDynProxy proxy = new MyDynProxy(landLord);

        IRent newTargetProxy = (IRent) proxy.newTargetProxy();

        newTargetProxy.rent();

    }
}
