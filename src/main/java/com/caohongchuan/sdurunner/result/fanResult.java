package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.userRank;

import java.util.List;


/**
 * 粉丝列表/关注列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class fanResult extends Result{
    private List<userRank> fans;

    public fanResult(int code, List<userRank> fans) {
        super(code);
        this.fans = fans;
    }

    public List<userRank> getFans() {
        return fans;
    }

    public void setFans(List<userRank> fans) {
        this.fans = fans;
    }

    @Override
    public String toString() {
        return "fanResult{" +
                "fans=" + fans +
                '}';
    }
}
