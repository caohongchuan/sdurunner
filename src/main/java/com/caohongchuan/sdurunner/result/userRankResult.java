package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.userRank;
import com.caohongchuan.sdurunner.exception.BaseErrorInfoInterface;

import java.util.List;


/**
 * 用户运动排名列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class userRankResult extends Result {

    private List<userRank> follow;

    public userRankResult(int code, String errormsg, List<userRank> follow) {
        super(code, errormsg);
        this.follow = follow;
    }

    public userRankResult(BaseErrorInfoInterface baseErrorInfoInterface, List<userRank> follow){
        super(baseErrorInfoInterface);
        this.follow = follow;
    }
    public List<userRank> getFollow() {
        return follow;
    }

    public void setFollow(List<userRank> follow) {
        this.follow = follow;
    }

    @Override
    public String toString() {
        return "userRankResult{" +
                "follow=" + follow +
                '}';
    }
}

