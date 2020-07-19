package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer ID;
    private String ROLE_NAME;
    private String ROLE_DESC;

    //从Role表出发的一对多关系
    private List<User> users;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getROLE_DESC() {
        return ROLE_DESC;
    }

    public void setROLE_DESC(String ROLE_DESC) {
        this.ROLE_DESC = ROLE_DESC;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", ROLE_NAME='" + ROLE_NAME + '\'' +
                ", ROLE_DESC='" + ROLE_DESC + '\'' +
                ", users=" + users +
                '}';
    }
}
