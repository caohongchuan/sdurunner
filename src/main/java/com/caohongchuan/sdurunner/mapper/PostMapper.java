package com.caohongchuan.sdurunner.mapper;

import com.caohongchuan.sdurunner.domain.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public interface PostMapper {

    @Insert("insert into Post(uid, duration, distance, time, rgpslist, permission, msg)" +
            "values(#{uid}, #{duration}, #{distance}, #{time}, #{rgpslist}, #{permission}, #{msg})")
    public int newpost(Post post);

    @Select("select * from Post where uid = #{uid}")
    public ArrayList<Post> getPost(@Param("uid")int uid);

    @Update("update Post set permission = #{permission}, " +
                            "msg = #{msg} "+
                            "where pid = #{pid}")
    public int updatePost(Post post);

    @Select("select distance from Post where pid = #{pid} and " +
                                            "uid = #{uid}")
    Integer getDistance(@Param("pid")int pid, @Param("uid")int uid);

    @Select("select pid from Post where uid = #{uid} order by time desc limit 1")
    Integer getNewPostPid(@Param("uid")int uid);


}
