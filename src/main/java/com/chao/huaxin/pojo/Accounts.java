package com.chao.huaxin.pojo;

public class Accounts {

    private Integer id;
    private String account;
    private String user;

    public Accounts() {
    }

    public Accounts(String account, String user) {
        this.account = account;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
