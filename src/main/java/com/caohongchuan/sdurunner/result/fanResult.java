package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.userRank;
import com.caohongchuan.sdurunner.exception.BaseErrorInfoInterface;

import java.util.List;


/**
 * 粉丝列表/关注列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class fanResult extends Result{
    private List<userRank> fans;

    public fanResult(int code, String errormsg, List<userRank> fans) {
        super(code, errormsg);
        this.fans = fans;
    }

    public fanResult(BaseErrorInfoInterface baseErrorInfoInterface, List<userRank> fans){
        super(baseErrorInfoInterface);
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
