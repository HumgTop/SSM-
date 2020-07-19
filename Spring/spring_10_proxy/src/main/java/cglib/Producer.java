package cglib;

public class Producer {
    public void sellProduct(float money) {
        System.out.println("出厂价："+money);
    }

    public void afterService(float money) {
        System.out.println("售后服务价："+money);
    }
}
