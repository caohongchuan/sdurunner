package com.caohongchuan.sdurunner.mapper;

import com.caohongchuan.sdurunner.domain.Post;
import com.caohongchuan.sdurunner.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface UserMapper {

    @Select("select profilepic from User where uid = #{uid}")
    String getUserProfilepic(@Param("uid") int uid);

    @Select("select password from User where nickname = #{nickname}")
    String getPassword(@Param("nickname") String nickname);

    @Insert("insert into User(nickname, password, regtime) values(#{nickname}, #{password}, #{regtime})")
    int insert(@Param("nickname") String nickname, @Param("password") String password, @Param("regtime") java.sql.Date regtime);

    @Select("select * from User where nickname = #{nickname}")
//    @Results({
//            @Result(column="gender", property = "gender"),
//            @Result(column="birthday", property = "birthday"),
//            @Result(column="weight", property = "weight"),
//            @Result(column="height", property = "height"),
//            @Result(column="regtime", property = "regtime"),
//            @Result(column="profilepic", property = "profilepic"),
//            @Result(column="totaldistance", property = "totaldistance"),
//            @Result(column="totalduration", property = "totalduration"),
//    })
    User getUserInfo(@Param("nickname") String nickname);


    @Update("update User set nickname = #{nickname}, " +
                            "password = #{password}, " +
                            "gender = #{gender}, " +
                            "birthday = #{birthday}, "+
                            "weight = #{weight}, " +
                            "height = #{height}, " +
                            "profilepic = #{profilepic} "+
                            "where nickname = #{nickname}")
    int updateUserInfo(User user);

    @Select("select uid from User where nickname = #{nickname}")
    Integer getUserId(@Param("nickname")String nickname);

    @Select("select nickname from User where uid = #{uid}")
    String getUserName(@Param("uid")int uid);

    @Insert("insert into Follow(uid, tarid, time) values(#{uid}, #{tarid}, #{time})")
    int newFollow(@Param("uid")int uid, @Param("tarid")int tarid, @Param("time")java.sql.Date time);

    @Delete("delete from Follow where uid = #{uid} and tarid = #{tarid}")
    int deleteFollow(@Param("uid")int uid, @Param("tarid")int tarid);

    @Select("select uid from Follow where tarid = #{tarid}")
    ArrayList<Integer> getFansId(@Param("tarid") int tarid);

    @Select("select tarid from Follow where uid = #{uid}")
    ArrayList<Integer> getFollowId(@Param("uid") int uid);

    @Select("select totaldistance from User where uid = #{uid}")
    long getRunDistance(@Param("uid")int uid);

    @Select("select totaldistance from User where nickname = #{nickname}")
    long getRunDistanceByName(@Param("nickname")String nickname);

    @Select("select uid from User ORDER BY RAND() LIMIT 5")
    ArrayList<Integer> getRandomUser();

    @Update("update User set totaldistance = totaldistance + #{distance}, " +
                            "totalduration = totalduration + #{duration} " +
                            "where uid = #{uid}")
    int updateData(Post post);
}
