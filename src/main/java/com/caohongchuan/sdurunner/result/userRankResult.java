package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.userRank;

import java.util.List;


/**
 * 用户运动排名列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class userRankResult extends Result {

    private List<userRank> follow;

    public userRankResult(int code, List<userRank> follow){
        super(code);
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

