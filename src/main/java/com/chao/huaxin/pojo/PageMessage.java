package com.chao.huaxin.pojo;

public class PageMessage {

    private Integer status;
    private String message;

    public PageMessage() {
    }

    public PageMessage(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PageMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
