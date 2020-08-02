package com.caohongchuan.sdurunner.service;

/**
 * 用户信息的服务层函数
 * @author caohongchuan
 * @version 1.0
 */


import com.caohongchuan.sdurunner.domain.User;
import com.caohongchuan.sdurunner.domain.userRank;
import com.caohongchuan.sdurunner.exception.CommonEnum;
import com.caohongchuan.sdurunner.exception.RunnerException;
import com.caohongchuan.sdurunner.mapper.UserMapper;
import com.caohongchuan.sdurunner.result.Result;
import com.caohongchuan.sdurunner.result.fanResult;
import com.caohongchuan.sdurunner.result.userInfoResult;
import com.caohongchuan.sdurunner.result.userRankResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 创建新的用户
     * @param nickname
     * @param password
     * @return @code{true} : 200  else @code{false}
     */

    public int createUser(String nickname, String password){
        //判断名字是否存在
        Integer uid = userMapper.getUserId(nickname);
        if(uid != null){
            throw new RunnerException(CommonEnum.USEREXITED);
        }

        Date date = new Date();
        java.sql.Date regtime = new java.sql.Date(date.getTime());

        try{
            userMapper.insert(nickname, password, regtime);
        }catch (Exception e){
            throw new RunnerException(CommonEnum.USERREGISTERERROR);
        }

        return 200;
    }

    /**
     * 用户登录函数
     * @param nickname
     * @param password
     * @return @code{true} : 200  else @code{false}
     */

    public int loginUser(String nickname, String password){
        String passwd = userMapper.getPassword(nickname);
        //用户名不存在
        if(passwd == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }

        if(passwd.equals(password)){
            return 200;
        }else{
            //用户密码错误
            throw new RunnerException(CommonEnum.PASSWORDERROR);
        }
    }

    /**
     * 获取个人信息内容
     * @param nickname
     * @return 个人信息 @link{userInfoResult}
     */

    public userInfoResult getUserInfo(String nickname){
        User res = userMapper.getUserInfo(nickname);
        long distance = userMapper.getRunDistanceByName(nickname);

        String rankname;
        if(distance <= 10000){
            rankname = "运动青铜";
        }else if(distance <= 50000){
            rankname = "运动白银";
        }else if(distance <= 100000){
            rankname = "运动黄金";
        }else if(distance <= 200000){
            rankname = "运动白金";
        }else if(distance <= 500000){
            rankname = "运动钻石";
        }else{
            rankname = "运动王者";
        }
        res.setRankname(rankname);


        if(res == null){
            return new userInfoResult(CommonEnum.USERUNEXITED, res);
        }else{
            return new userInfoResult(CommonEnum.SUCCESS, res);
        }
    }

    /**
     * 更新用户信息
     * @param user
     * @return @code{true} : 200  else @code{false}
     */

    public Result updateUserInfo(User user){
        int success = userMapper.updateUserInfo(user);
        if(success > 0){
            //更新超过1条数据，成功
            return new Result(CommonEnum.SUCCESS);
        }else{
            //个人信息更新失败
            throw new RunnerException(CommonEnum.USERUPDATEERROR);
        }
    }

    /**
     * 关注新朋友
     * @param nickname1
     * @param nickname2
     * @return @code{true} : 200  else @code{false}
     */

    public Result newFollow(String nickname1, String nickname2){
        Integer uid = userMapper.getUserId(nickname1);
        Integer tarid = userMapper.getUserId(nickname2);
        if(uid == null || tarid == null){
            //用户不存在
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int success = userMapper.newFollow(uid, tarid, sqlDate);
        if(success > 0){
            return new Result(CommonEnum.SUCCESS);
        }else{
            throw new RunnerException(CommonEnum.ADDLIKEERROR);
        }
    }

    /**
     * 删除关注
     * @param nickname1
     * @param nickname2
     * @return @code{true} : 200  else @code{false}
     */

    public Result deleteFollow(String nickname1, String nickname2){
        Integer uid = userMapper.getUserId(nickname1);
        Integer tarid = userMapper.getUserId(nickname2);
        if(uid == null || tarid == null){
            //用户不存在
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }
        int success = userMapper.deleteFollow(uid, tarid);

        if(success > 0){
            return new Result(CommonEnum.SUCCESS);
        }else{
            throw new RunnerException(CommonEnum.CANCELATTENTIONERROR);
        }
    }

    /**
     * 获取粉丝列表
     * @param nickname
     * @return 粉丝信息列表 @link{fanResult}
     */

    public fanResult getFans(String nickname){

        Integer tarid = userMapper.getUserId(nickname);
        if(tarid == null){
            return new fanResult(CommonEnum.USERUNEXITED, null);
        }
        ArrayList<userRank> nameList;
        try {
            ArrayList<Integer> idList = userMapper.getFansId(tarid);
            nameList = new ArrayList<>(idList.size());

            for (int i = 0; i < idList.size(); i++) {
                int uid = idList.get(i);
                String username = userMapper.getUserName(uid);
                String profilepic = userMapper.getUserProfilepic(uid);
                long rundistance = userMapper.getRunDistance(uid);
                nameList.add(i, new userRank(uid, username, rundistance, profilepic));
            }
        }catch (Exception exception){
            return new fanResult(CommonEnum.GETFANERROR, null);
        }
        return new fanResult(CommonEnum.SUCCESS, nameList);

    }

    /**
     * 获取关注者列表
     * @param nickname
     * @return 关注着信息列表 @link{fanResult}
     */

    public fanResult getFollow(String nickname){
        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            throw new RunnerException(CommonEnum.USERUNEXITED);
        }

        ArrayList<userRank> nameList;

        try {
            ArrayList<Integer> idList = userMapper.getFollowId(uid);
            nameList = new ArrayList<>(idList.size());

            for (int i = 0; i < idList.size(); i++) {
                int uidF = idList.get(i);
                String username = userMapper.getUserName(uidF);
                String profilepic = userMapper.getUserProfilepic(uidF);
                long rundistance = userMapper.getRunDistance(uidF);
                nameList.add(i, new userRank(uidF, username, rundistance, profilepic));
            }
        }catch (Exception exception){
            throw new RunnerException(CommonEnum.GETFOCUSERROR);
        }

        return new fanResult(CommonEnum.SUCCESS, nameList);
    }

    /**
     * 获取朋友列表排名
     * @param nickname
     * @return 朋友运动排名 @link{userRankResult}
     */

    public userRankResult getFriendRank(String nickname){
        Integer uid = userMapper.getUserId(nickname);
        if(uid == null){
            return new userRankResult(CommonEnum.USERUNEXITED, null);
        }
        ArrayList<userRank> userrank;


        try {
            ArrayList<Integer> idList = userMapper.getFollowId(uid);
            userrank = new ArrayList<>(idList.size());
            //判断关注列表是否有自己
            boolean haveself = false;

            for (int i = 0; i < idList.size(); i++) {
                int frienduid = idList.get(i);

                //有自己
                if(frienduid == uid){
                    haveself = true;
                }

                String friendname = userMapper.getUserName(frienduid);
                long rundistance = userMapper.getRunDistance(frienduid);
                String profilepic = userMapper.getUserProfilepic(frienduid);
                userrank.add(new userRank(frienduid, friendname, rundistance, profilepic));
            }

            if(!haveself){
                long rundistance = userMapper.getRunDistance(uid);
                String profilepic = userMapper.getUserProfilepic(uid);
                userrank.add(new userRank(uid, nickname, rundistance, profilepic));
            }

            Collections.sort(userrank);
        }catch (Exception exception){
            return new userRankResult(CommonEnum.GETFRIENDRANKERROR, null);
        }

        return new userRankResult(CommonEnum.SUCCESS, userrank);
    }

}
