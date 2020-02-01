package com.chao.huaxin.pojo;

public class Sites {

    private Integer id;
    private String  site;
    private String deled;

    public Sites() {
    }

    public Sites(String site) {
        this.site = site;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDeled() {
        return deled;
    }

    public void setDeled(String deled) {
        this.deled = deled;
    }

    @Override
    public String toString() {
        return "Sties{" +
                "id=" + id +
                ", site='" + site + '\'' +
                ", deled='" + deled + '\'' +
                '}';
    }
}
