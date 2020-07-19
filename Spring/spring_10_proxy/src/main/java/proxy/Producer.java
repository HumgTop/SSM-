package proxy;

public interface Producer {
    void sellProduct(float money);

    void afterService(float money);

    int printNum(int num);

    String printStr(String string);
}
