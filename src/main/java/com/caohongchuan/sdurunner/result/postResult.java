package com.caohongchuan.sdurunner.result;

import com.caohongchuan.sdurunner.domain.Post;

import java.util.ArrayList;


/**
 * 动态列表 结果
 * @author caohongchuan
 * @version 1.0
 */

public class postResult extends Result{

    ArrayList<Post> postList;

    public postResult(int code, ArrayList<Post> postList){
        super(code);
        this.postList = postList;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "postResult{" +
                "postList=" + postList +
                '}';
    }
}
