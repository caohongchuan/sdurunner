package com.caohongchuan.sdurunner.web;

/**
 * 用于接收前端发送的评论请求
 * @author caohongchuan
 * @version 1.0
 */

import com.caohongchuan.sdurunner.domain.Reaction;
import com.caohongchuan.sdurunner.result.Result;
import com.caohongchuan.sdurunner.result.commitResult;
import com.caohongchuan.sdurunner.service.CommitSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/commit")
public class CommitController {
    @Autowired
    CommitSerivce commitSerivce;

    /**
     * 创建新的评论
     * @param reaction
     * @return @code{true} or @code{false}
     */

    @CrossOrigin
    @RequestMapping(value = "/newcommit",method = RequestMethod.POST)
    @ResponseBody
    public Result newCommit(Reaction reaction){
        int success = commitSerivce.newCommit(reaction);
        return new Result(success);

    }

    /**
     * 删除评论
     * @param pid
     * @param nickname
     * @return @code{true} or @code{false}
     */

    @CrossOrigin
    @RequestMapping(value = "/deletecommit",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCommit(@RequestParam("pid")int pid, @RequestParam("nickname")String nickname){

        int success = commitSerivce.deleteCommit(pid, nickname);
        return new Result(success);
    }

    /**
     * 创建新的点赞
     * @param reaction
     * @return @code{true} or @code{false}
     */

    @CrossOrigin
    @RequestMapping(value = "/newlike",method = RequestMethod.POST)
    @ResponseBody
    public Result newLike(Reaction reaction){
        int success = commitSerivce.newLike(reaction);
        return new Result(success);

    }

    /**
     * 删除点赞
     * @param pid
     * @param nickname
     * @return @code{true} or @code{false}
     */

    @CrossOrigin
    @RequestMapping(value = "/deletelike",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteLike(@RequestParam("pid")int pid, @RequestParam("nickname")String nickname){

        int success = commitSerivce.deleteLike(pid, nickname);
        return new Result(success);
    }


    /**
     * 获得评论
     * @param pid
     * @return 评论内容 @link{commitResult}
     */

    @CrossOrigin
    @RequestMapping(value = "/getcommit",method = RequestMethod.POST)
    @ResponseBody
    public commitResult getCommit(@RequestParam("pid")int pid){
        return commitSerivce.getCommit(pid);
    }

    /**
     * 获得点赞
     * @param pid
     * @return 点赞内容  @link{commitResult}
     */

    @CrossOrigin
    @RequestMapping(value = "/getlike",method = RequestMethod.POST)
    @ResponseBody
    public commitResult getLike(@RequestParam("pid")int pid){
        return commitSerivce.getLike(pid);
    }




}
