package com.caohongchuan.sdurunner.web;

import com.caohongchuan.sdurunner.domain.User;
import com.caohongchuan.sdurunner.result.Result;
import com.caohongchuan.sdurunner.result.fanResult;
import com.caohongchuan.sdurunner.result.userInfoResult;
import com.caohongchuan.sdurunner.result.userRankResult;
import com.caohongchuan.sdurunner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用于接收前端发送的用户信息请求
 * @author caohongchuan
 * @version 1.0
 */


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param nickname
     * @param password
     * @return @code{true} or @code{false}
     */


    @CrossOrigin
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestParam("nickname")String nickname, @RequestParam("password")String password) {
        int success = userService.createUser(nickname, password);
        return new Result(success);
    }

    /**
     * 用户登录
     * @param session
     * @param nickname
     * @param password
     * @return @code{true} or @code{false}
     */

    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpSession session, @RequestParam("nickname")String nickname, @RequestParam("password")String password) {

        int success = userService.loginUser(nickname, password);

        String storedName = (String) session.getAttribute("user");
        if(storedName == null){
            session.setAttribute("user", nickname);
        }
        return new Result(success);
    }

    /**
     * 获取用户信息
     * @param nickname
     * @return 用户信息 @link{userInfoResult}
     */
    @CrossOrigin
    @RequestMapping(value = "/getuserinfo",method = RequestMethod.POST)
    @ResponseBody
    public userInfoResult getuserinfo(@RequestParam("nickname")String nickname) {
        userInfoResult userinfo = userService.getUserInfo(nickname);
        return userinfo;
    }

    /**
     * 更新用户信息
     * @param user
     * @return @code{true} or @code{false}
     */
    @CrossOrigin
    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.POST)
    @ResponseBody
    public Result updateUserInfo(User user) {
        int success = userService.updateUserInfo(user);
        return new Result(success);
    }

    /**
     * 增加用户关注
     * @param nickname1
     * @param nickname2
     * @return @code{true} or @code{false}
     */
    @CrossOrigin
    @RequestMapping(value = "/newfollow",method = RequestMethod.POST)
    @ResponseBody
    public Result newFollow(@RequestParam("nickname1")String nickname1, @RequestParam("nickname2")String nickname2) {
        int success = userService.newFollow(nickname1, nickname2);
        return new Result(success);
    }

    /**
     * 删除用户关注
     * @param nickname1
     * @param nickname2
     * @return @code{true} or @code{false}
     */
    @CrossOrigin
    @RequestMapping(value = "/deletefollow",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteFollow(@RequestParam("nickname1")String nickname1, @RequestParam("nickname2")String nickname2) {
        int success = userService.deleteFollow(nickname1, nickname2);
        return new Result(success);
    }


    /**
     * 获得用户粉丝列表
     * @param nickname
     * @return 粉丝列表 @link{fanResult}
     */
    @CrossOrigin
        @RequestMapping(value = "/getfollowfans",method = RequestMethod.POST)
    @ResponseBody
    public fanResult getFollowFans(@RequestParam("nickname")String nickname) {
        return userService.getFans(nickname);
    }

    /**
     * 获得用户关注列表
     * @param nickname
     * @return 关注列表 @link{fanResult}
     */
    @CrossOrigin
    @RequestMapping(value = "/getfollow",method = RequestMethod.POST)
    @ResponseBody
    public fanResult getFollow(@RequestParam("nickname")String nickname) {
        return userService.getFollow(nickname);
    }

    /**
     * 获得用户关注列表排名
     * @param nickname
     * @return 关注列表用户的排名信息 @link{userRankResult}
     */

    @CrossOrigin
    @RequestMapping(value = "/getfollowrank",method = RequestMethod.POST)
    @ResponseBody
    public userRankResult getFollowRank(@RequestParam("nickname")String nickname) {
        return userService.getFriendRank(nickname);
    }



}
