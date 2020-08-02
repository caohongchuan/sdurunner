package com.caohongchuan.sdurunner.service;

/**
 * 用户动态相关的服务层函数
 * @author caohongchuan
 * @version 1.0
 */

import com.caohongchuan.sdurunner.domain.Post;
import com.caohongchuan.sdurunner.domain.Reaction;
import com.caohongchuan.sdurunner.exception.CommonEnum;
import com.caohongchuan.sdurunner.exception.RunnerException;
import com.caohongchuan.sdurunner.mapper.PostMapper;
import com.caohongchuan.sdurunner.mapper.UserMapper;
import com.caohongchuan.sdurunner.result.postResult;
import org.apache.ibatis.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommitSerivce commitSerivce;

    /**
     * 创建新的动态
     * @param post
     * @return
     */

    public postResult newpost(Post post){
        //发布新post 插入后再将post返回前端
        ArrayList<Post> getPost = new ArrayList<>(1);

        String nickname = post.getNickname();
        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }
        post.setUid(uid);

        Date date = new Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        post.setTime(timestamp);
        int success;

        //插入出错
        try {
            success = postMapper.newpost(post);
            userMapper.updateData(post);

            Integer pid = postMapper.getNewPostPid(uid);
            post.setPid(pid);
            getPost.add(post);
        }catch (Exception exception){
            throw new RunnerException(CommonEnum.INSERTPOSTERROR);
        }


        if(success > 0){
            return new postResult(CommonEnum.SUCCESS, getPost);
        }else{
            throw new RunnerException(CommonEnum.INSERTPOSTERROR);
        }
    }

    /**
     * 获得动态
     * @param nickname
     * @return 动态列表 @link{Post}
     */

    public ArrayList<Post> getPost(String nickname){
        ArrayList<Post> postList;

        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            postList = null;
            return postList;
        }
        //获得出错
        try {
            postList = postMapper.getPost(uid);
            String profilepic = userMapper.getUserProfilepic(uid);
            long totaldistance = userMapper.getRunDistance(uid);

            //加入评论
            for(int i=0; i<postList.size(); i++){
               Post post = postList.get(i);
               //set post profilepic / totaldistance
               post.setProfilepic(profilepic);
               post.setTotaldistance(totaldistance);

               int pid = post.getPid();
               post.getCommit().addAll(commitSerivce.getCommitAll(pid).getCommitList());

            }

            Collections.sort(postList);
        }catch (Exception exception){
            System.out.println(exception);
            postList = null;
            return postList;
        }
        return postList;
    }

    /**
     * 更新动态内容
     * @param post
     * @return @code{true} : 200  else @code{false}
     */

    public int updatePost(Post post){
        //判断post是否为自己的
        Integer uid = userMapper.getUserId(post.getNickname());
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }
        //判断post是否为本人的
        Integer getDistance = postMapper.getDistance(post.getPid(), uid);
        if(getDistance == null){
            throw new RunnerException(CommonEnum.CANTCHANGEPOST);
        }

        int success;
        try {
            success = postMapper.updatePost(post);
        }catch (Exception exception){
            throw new RunnerException(CommonEnum.UPDATEPOSTERROR);
        }
        if(success > 0){
            return 200;
        }else{
            throw new RunnerException(CommonEnum.UPDATEPOSTERROR);
        }
    }

    /**
     * 获得朋友的动态列表
     * @param nickname
     * @return 动态列表 @link{postResult}
     */
    public postResult getFriendPost(String nickname){

        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }

        ArrayList<Post> friendPost;
        try {
            ArrayList<Integer> friendList = userMapper.getFollowId(uid);

            friendPost = new ArrayList<>();
            for (int i = 0; i < friendList.size(); i++) {
                int friendUid = friendList.get(i);
                String friendName = userMapper.getUserName(friendUid);
                String profilepic = userMapper.getUserProfilepic(friendUid);
                long totaldistance = userMapper.getRunDistance(friendUid);

                ArrayList<Post> somePost = postMapper.getPost(friendUid);

                for (int j = 0; j < somePost.size(); j++) {
                    Post post = somePost.get(j);
                    post.setNickname(friendName);
                    post.setProfilepic(profilepic);
                    post.setTotaldistance(totaldistance);

                    //添加评论
                    int pid = post.getPid();
                    post.getCommit().addAll(commitSerivce.getCommitAll(pid).getCommitList());
                }

                friendPost.addAll(somePost);
            }

            Collections.sort(friendPost);
        }catch (Exception exception){
            throw new RunnerException(CommonEnum.GETFRIENDPOSTERROR);
        }
        return new postResult(CommonEnum.SUCCESS, friendPost);
    }

    /**
     * 随机获取动态列表
     * @return 动态列表 @link{postResult}
     */
    public postResult getRandomPost(){

        ArrayList<Post> friendPost;
        try {
            ArrayList<Integer> friendList = userMapper.getRandomUser();

            friendPost = new ArrayList<>();

            for (int i = 0; i < friendList.size(); i++) {
                int friendUid = friendList.get(i);
                String friendName = userMapper.getUserName(friendUid);
                String profilepic = userMapper.getUserProfilepic(friendUid);
                long totaldistance = userMapper.getRunDistance(friendUid);

                ArrayList<Post> somePost = postMapper.getPost(friendUid);

                for (int j = 0; j < somePost.size(); j++) {
                    Post post = somePost.get(j);
                    post.setNickname(friendName);
                    post.setProfilepic(profilepic);
                    post.setTotaldistance(totaldistance);

                    //添加评论
                    int pid = post.getPid();
                    post.getCommit().addAll(commitSerivce.getCommitAll(pid).getCommitList());
                }

                friendPost.addAll(somePost);
            }

            Collections.sort(friendPost);
        }catch (Exception exception){
            throw new RunnerException(CommonEnum.GETRANDOMPOSTERROR);
        }
        return new postResult(CommonEnum.SUCCESS, friendPost);
    }
}
