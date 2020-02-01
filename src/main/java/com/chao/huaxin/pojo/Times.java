package com.chao.huaxin.pojo;

public class Times {

    private Integer id;
    private String time;
    private String status;

    public Times() {
    }

    public Times(Integer id, String time, String status) {
        this.id = id;
        this.time = time;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Times{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
