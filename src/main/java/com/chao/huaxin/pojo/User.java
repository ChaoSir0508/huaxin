package com.chao.huaxin.pojo;

public class User {

    private Integer id;
    private String  name;
    private String site;
    private String telephone;
    private String  account;
    private String status;
    private String time;
    private String  deled;

    public User() {
    }

    public User( String name, String site, String telephone, String account) {
        this.name = name;
        this.site = site;
        this.telephone = telephone;
        this.account = account;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeled() {
        return deled;
    }

    public void setDeled(String deled) {
        this.deled = deled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", telephone='" + telephone + '\'' +
                ", account='" + account + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", deled='" + deled + '\'' +
                '}';
    }
}
