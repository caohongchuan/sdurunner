package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.Reaction;
import com.caohongchuan.sdurunner.exception.BaseErrorInfoInterface;

import java.util.List;

/**
 * 用户评论列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class commitResult extends Result{

    private List<Reaction>  commitList;

    public commitResult(int code, String errormsg, List<Reaction> commitList) {
        super(code, errormsg);
        this.commitList = commitList;
    }

    public commitResult(BaseErrorInfoInterface baseErrorInfoInterface, List<Reaction> commitList){
        super(baseErrorInfoInterface);
        this.commitList = commitList;
    }

    public List<Reaction> getCommitList() {
        return commitList;
    }

    public void setCommitList(List<Reaction> commitList) {
        this.commitList = commitList;
    }
}
