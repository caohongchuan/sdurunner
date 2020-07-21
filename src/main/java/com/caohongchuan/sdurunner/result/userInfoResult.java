package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 *  个人用信息 结果
 * @author caohongchuan
 * @version 1.0
 */


public class userInfoResult extends Result {
    private User user;

    public userInfoResult(int code, User user){
        super(code);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "userInfoResult{" +
                "user=" + user +
                '}';
    }
}
