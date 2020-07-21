//package com.caohongchuan.sdurunner;
//
//import com.caohongchuan.sdurunner.domain.Post;
//import com.caohongchuan.sdurunner.domain.Reaction;
//import com.caohongchuan.sdurunner.domain.User;
//import com.caohongchuan.sdurunner.service.CommitSerivce;
//import com.caohongchuan.sdurunner.service.PostService;
//import com.caohongchuan.sdurunner.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//class SdurunnerApplicationTests {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    PostService postService;
//
//    @Autowired
//    CommitSerivce commitSerivce;
//
//    public static String name = "xiaoxiong";
//    public static String passwd = "mima";
//
//
//    @Test
//    void TestUserLogin() {
//
//
//        //创建用户
//        for(int i=0; i<20; i++){
//            userService.createUser(name+i, passwd+i);
//        }
//
//        for(int i=20; i<40; i++){
//            userService.createUser(name+i, passwd+i);
//        }
//
//        //用户登录
//        for(int i=0; i<5; i++){
//            System.out.println(userService.loginUser(name+i, passwd+i));
//        }
//        for(int i=5; i<10; i++){
//            System.out.println(userService.loginUser(name+i, passwd));
//        }
//        for(int i=10; i<15; i++){
//            System.out.println(userService.loginUser(name+30, passwd));
//        }
//
//
//
//    }
//
//
//    @Test
//    void TestUserInfo(){
//
//
//        User user = new User();
//
//        for(int i=0; i<10; i++){
//            user.setNickname(name+i);
//            user.setPassword(passwd+i);
//            user.setGender("1");
//            user.setBirthday(new java.sql.Date(new java.util.Date().getTime()));
//            user.setWeight(i);
//            user.setHeight(i);
//            user.setProfilepic("http//google.com/"+i);
//            userService.updateUserInfo(user);
//        }
//
//        for(int i=0; i<10; i++){
//            System.out.println(userService.getUserInfo(name+i));
//        }
//    }
//
//    @Test
//    void TestUserFollow(){
////        for(int i=0; i<9; i++){
////            userService.newFollow(name+i, name+(i+1));
////            userService.newFollow(name+i, name+(i+11));
////        }
//
//        for(int i=0; i<9; i++){
//            System.out.println(userService.getFollow(name+i));
//            System.out.println(userService.getFriendRank(name+i));
//        }
//
//        for(int i=10; i<20; i++){
//            System.out.println(userService.getFans(name+i));
//        }
//
//
//    }
//
//
//    @Test
//    void TestPost(){
//        Post post = new Post();
//        for(int i=0; i<20; i++){
//            post.setNickname(name + i);
//            post.setDuration(100+i);
//            post.setDistance(200+i);
//            post.setRgpslist("E110, N70");
//            post.setPermission(1);
//            post.setMsg("You are good! "+i);
//            postService.newpost(post);
//        }
//
//    }
//
//    @Test
//    void TestUpdatePost(){
//        Post post = new Post();
////        for(int i=10; i<19; i++){
////            post.setPid(i);
////            post.setPermission(2);
////            post.setMsg("I am a good child! "+i);
////            postService.updatePost(post);
////        }
//
//        post.setPid(10);
//        post.setNickname(name+3);
//        post.setPermission(2);
//        post.setMsg("I am a good child! ");
//        System.out.println(postService.updatePost(post));
//    }
//
//    @Test
//    void TestGetPost(){
//        for(int i=0; i<10; i++){
//            System.out.println(postService.getPost(name+i));
//        }
//
//        System.out.println("----------------------------------");
//
//        for(int i=0; i<9; i++){
//            System.out.println(postService.getFriendPost(name+i));
//        }
//
//        System.out.println("----------------------------------");
//
//        System.out.println(postService.getRandomPost());
//
//    }
//
//    @Test
//    void TestNewCommit(){
//        Reaction reaction = new Reaction();
//        for(int i=0; i<20; i++){
//            reaction.setNickname(name+i);
//            reaction.setPid(26-i);
//            reaction.setType(1);
//            reaction.setCommit("");
//            commitSerivce.newCommit(reaction);
//        }
//
//    }
//
//    @Test
//    void TestGetCommit(){
//        for(int i=0; i<10; i++){
//            System.out.println(commitSerivce.getCommit(i+10));
//        }
//
//    }
//
//    @Test
//    void TestDeleteCommit(){
//
//        for(int i=0; i<10; i++){
//            commitSerivce.deleteCommit(10+i, name+i, 3);
//        }
//    }
//
//
//    @Test
//    void TestT(){
//        for(int i=20; i<40; i++){
//            userService.createUser(name+i, passwd+i);
//        }
//    }
//
//}
