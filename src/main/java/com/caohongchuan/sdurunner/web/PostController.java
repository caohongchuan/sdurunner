package com.caohongchuan.sdurunner.web;

/**
 * 用于接收前端发送的动态请求
 * @author caohongchuan
 * @version 1.0
 */


import com.caohongchuan.sdurunner.domain.Post;
import com.caohongchuan.sdurunner.exception.CommonEnum;
import com.caohongchuan.sdurunner.exception.RunnerException;
import com.caohongchuan.sdurunner.result.Result;
import com.caohongchuan.sdurunner.result.postResult;
import com.caohongchuan.sdurunner.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;


@Controller
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;


    /**
     * 发布动态
     * @param post
     * @return  @code{true} or @code{false}
     */
    @CrossOrigin
    @RequestMapping(value = "/newpost",method = RequestMethod.POST)
    @ResponseBody
    public postResult newpost(Post post) {
        return postService.newpost(post);
    }


    /**
     * 获取动态（全部）
     * @param nickname
     * @return 动态内容 @link{postResult}
     */
    @CrossOrigin
    @RequestMapping(value = "/getpost",method = RequestMethod.POST)
    @ResponseBody
    public postResult getpost(@RequestParam("nickname")String nickname) {

        ArrayList<Post> success = null;
        success = postService.getPost(nickname);
        if(success == null){
            throw new RunnerException(CommonEnum.GETPOSTERROR);
        }else{
            return new postResult(CommonEnum.SUCCESS, success);
        }

    }



    /**
     * 编辑动态
     * @param post
     * @return @code{true} or @code{false}
     */

    @CrossOrigin
    @RequestMapping(value = "/updatepost",method = RequestMethod.POST)
    @ResponseBody
    public Result updatepost(Post post) {

        int success = postService.updatePost(post);
        if(success == 200){
            return new Result(CommonEnum.SUCCESS);
        }else{
            throw new RunnerException(CommonEnum.UPDATEPOSTERROR);
        }
    }


    /**
     * 获得好友动态
     * @param nickname
     * @return 动态内容 @link{postResult}
     */
    @CrossOrigin
    @RequestMapping(value = "/getfriendpost",method = RequestMethod.POST)
    @ResponseBody
    public postResult getFriendPost(@RequestParam("nickname")String nickname) {
         return  postService.getFriendPost(nickname);
    }


    /**
     * 随机获得动态
     * @return 动态内容 @link{postResult}
     */
    @CrossOrigin
    @RequestMapping(value = "/getrandompost",method = RequestMethod.POST)
    @ResponseBody
    public postResult getRandomPost() {
        return  postService.getRandomPost();
    }


}
