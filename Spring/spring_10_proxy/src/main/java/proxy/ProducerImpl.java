package proxy;

public class ProducerImpl implements Producer{
    public void sellProduct(float money) {
        System.out.println("出厂价："+money);
    }

    public void afterService(float money) {
        System.out.println("售后服务价："+money);
    }

    @Override
    public int printNum(int num) {
        return num;
    }

    @Override
    public String printStr(String string) {
        return string;
    }


}
