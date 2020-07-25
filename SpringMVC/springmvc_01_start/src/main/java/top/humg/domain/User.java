package top.humg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private String uname;
    private Integer age;
    private Account account;
    private Date birth;
    private List<Account> accountList;
    private Map<String, Account> accountMap;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", account=" + account +
                ", birth=" + birth +
                ", accountList=" + accountList +
                ", accountMap=" + accountMap +
                '}';
    }
}
