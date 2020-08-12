package com.caohongchuan.sdurunner.domain;

public class MsgVO {
    private Integer userId;
    private String username;
    private String avatar;
    private String msg;
    private int count;

    public MsgVO(){}

    public MsgVO(Integer userId, String username, String avatar, String msg, int count) {
        this.userId = userId;
        this.username = username;
        this.avatar = avatar;
        this.msg = msg;
        this.count = count;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
