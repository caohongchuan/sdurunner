package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.Reaction;

import java.util.List;

/**
 * 用户评论列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class commitResult extends Result{

    private List<Reaction>  commitList;

    public commitResult(int code, List<Reaction> commitList){
        super(code);
        this.commitList = commitList;
    }

    public List<Reaction> getCommitList() {
        return commitList;
    }

    public void setCommitList(List<Reaction> commitList) {
        this.commitList = commitList;
    }
}
