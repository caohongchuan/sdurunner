package com.caohongchuan.sdurunner.service;

/**
 * 评论，点赞的服务层函数
 * @author caohongchuan
 * @version 1.0
 */

import com.caohongchuan.sdurunner.domain.Reaction;
import com.caohongchuan.sdurunner.exception.CommonEnum;
import com.caohongchuan.sdurunner.exception.RunnerException;
import com.caohongchuan.sdurunner.mapper.CommitMapper;
import com.caohongchuan.sdurunner.mapper.UserMapper;
import com.caohongchuan.sdurunner.result.commitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommitSerivce {

    @Autowired
    CommitMapper commitMapper;

    @Autowired
    UserMapper userMapper;


    /**
     * 创建新的评论
     * @param reaction
     * @return @code{true} : 200 , else @code{false}
     */
    public int newCommit(Reaction reaction){
        int success=0;

        String nickname = reaction.getNickname();
        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }
        reaction.setUid(uid);
        reaction.setType(2);

        long pid = reaction.getPid();
        Integer type = commitMapper.getType((int)pid, uid);

        if(type == null){

            try {
                success = commitMapper.newCommit(reaction);
            }catch (Exception exception){
                throw new RunnerException(CommonEnum.ADDCOMMITERROR);
            }

        }else if(type == 1){
            success = commitMapper.setCommit2((int)pid, uid, 3, reaction.getCommit());
        }else if(type == 2){
            success = 0;
        }else{
            success = 0;
        }


        if(success > 0){
            return 200;
        }else{
            throw new RunnerException(CommonEnum.ADDCOMMITERROR);
        }
    }

    /**
     * 创建新的点赞
     * @param reaction
     * @return @code{true} : 200 , else @code{false}
     */

    public int newLike(Reaction reaction){
        int success=0;

        String nickname = reaction.getNickname();
        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }
        reaction.setUid(uid);
        reaction.setType(1);

        long pid = reaction.getPid();
        Integer type = commitMapper.getType((int)pid, uid);

        if(type == null){

            try {
                success = commitMapper.newCommit(reaction);
            }catch (Exception exception){
                throw new RunnerException(CommonEnum.ADDLIKEERROR);
            }

        }else if(type == 1){
            success = 0;
        }else if(type == 2){
            success = commitMapper.setCommit1((int)pid, uid, 3);
        }else{
            success = 0;
        }


        if(success > 0){
            return 200;
        }else{
            throw new RunnerException(CommonEnum.ADDLIKEERROR);
        }
    }

    /**
     * 获得评论信息
     * @param pid
     * @return 评论信息 @link{commitResult}
     */

    public commitResult getCommit(int pid){
        List<Reaction> commitList;
        try {
            commitList = commitMapper.getCommit(pid);
        }catch (Exception exception){
            //获得失败
            throw new RunnerException(CommonEnum.DELETECOMMITERROR);
        }

        //添加用户名字
        for(int i=0; i < commitList.size(); i++){
            Reaction reaction = commitList.get(i);
            int uid = (int)reaction.getUid();
            reaction.setNickname(userMapper.getUserName(uid));
            reaction.setDistance(userMapper.getRunDistance(uid));
            reaction.setProfilepic(userMapper.getUserProfilepic(uid));
        }
        return new commitResult(CommonEnum.SUCCESS, commitList);
    }

    /**
     * 获取点赞信息
     * @param pid
     * @return 点赞信息 @link{commitResult}
     */

    public commitResult getLike(int pid){
        List<Reaction> commitList;
        try {
            commitList = commitMapper.getLike(pid);
        }catch (Exception exception){
            //获得失败
            throw new RunnerException(CommonEnum.GETLIKEERROR);
        }

        //添加用户名字
        for(int i=0; i < commitList.size(); i++){
            Reaction reaction = commitList.get(i);
            int uid = (int)reaction.getUid();
            reaction.setNickname(userMapper.getUserName(uid));
            reaction.setDistance(userMapper.getRunDistance(uid));
            reaction.setProfilepic(userMapper.getUserProfilepic(uid));
        }
        return new commitResult(CommonEnum.SUCCESS, commitList);
    }

    /**
     * 删除评论信息
     * @param pid
     * @param nickname
     * @return @code{true} : 200  else @code{false}
     */

    public int deleteCommit(int pid, String nickname){
        int success = 0;

        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }

        Integer committype;
        try {
            committype = commitMapper.getType(pid, uid);
        }catch (Exception exception){
            throw new RunnerException(CommonEnum.DELETECOMMITERROR);
        }


        if(committype == null){
            throw new RunnerException(CommonEnum.DELETECOMMITERROR);

        }else if(committype == 2){
            success = commitMapper.deleteCommit(pid, uid);

            if(success > 0){
                return 200;
            }else{
                throw new RunnerException(CommonEnum.DELETECOMMITERROR);
            }
        }else if(committype == 3){
            String str = "";
            commitMapper.setCommit2(pid, uid, 1, str);
            return 200;

        }else{
            throw new RunnerException(CommonEnum.DELETECOMMITERROR);
        }


    }

    /**
     * 删除点赞信息
     * @param pid
     * @param nickname
     * @return  @code{true} : 200  else @code{false}
     */

    public int deleteLike(int pid, String nickname){
        int success = 0;

        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            return 303;
        }

        Integer committype;
        try {
            committype = commitMapper.getType(pid, uid);
        }catch (Exception exception){
            return 342;
        }


        if(committype == null){
            return 342;

        }else if(committype == 1){
            success = commitMapper.deleteCommit(pid, uid);

            if(success > 0){
                return 200;
            }else{
                return 342;
            }
        }else if(committype == 3){
            String str = "";
            commitMapper.setCommit1(pid, uid, 2);
            return 200;
        }else{

            return 342;
        }


    }

    /**
     * 获得所有评论信息
     * @param pid
     * @return 评论信息列表 @link{commitResult}
     */

    public commitResult getCommitAll(int pid){
        List<Reaction> commitList;
        try {
            commitList = commitMapper.getCommitAll(pid);
        }catch (Exception exception){
            //获得失败
            throw new RunnerException(CommonEnum.GETCOMMITERROR);
        }

        //添加用户名字
        for(int i=0; i < commitList.size(); i++){
            Reaction reaction = commitList.get(i);
            int uid = (int)reaction.getUid();
            reaction.setNickname(userMapper.getUserName(uid));
            reaction.setDistance(userMapper.getRunDistance(uid));
            reaction.setProfilepic(userMapper.getUserProfilepic(uid));
        }
        return new commitResult(CommonEnum.SUCCESS, commitList);
    }


}
