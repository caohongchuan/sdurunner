package com.caohongchuan.sdurunner.mapper;

import com.caohongchuan.sdurunner.domain.Reaction;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitMapper {



    @Insert("insert into Reaction(type, uid, pid, commit) " +
            "values(#{type}, #{uid}, #{pid}, #{commit})")
    public int newCommit(Reaction reaction);

    @Select("select * from Reaction where pid = #{pid} and (type = 2 or type = 3)")
    public List<Reaction> getCommit(@Param("pid") int pid);

    @Select("select * from Reaction where pid = #{pid} and (type = 1 or type = 3)")
    public List<Reaction> getLike(@Param("pid") int pid);

    @Select("select * from Reaction where pid = #{pid}")
    public List<Reaction> getCommitAll(@Param("pid") int pid);

    @Select("select type from Reaction where pid = #{pid} and uid = #{uid}")
    public Integer getType(@Param("pid")int pid, @Param("uid")int uid);

    @Delete("delete from Reaction where pid = #{pid} and uid = #{uid}")
    public int deleteCommit(@Param("pid")int pid, @Param("uid")int uid);

    @Update("update Reaction set type = #{type} "+
                                "where pid = #{pid} and uid = #{uid}")
    public int setCommit1(@Param("pid")int pid, @Param("uid")int uid, @Param("type")int type);

    @Update("update Reaction set type = #{type}, "+
                                "commit = #{commit} " +
                                "where pid = #{pid} and uid = #{uid}")
    public int setCommit2(@Param("pid")int pid, @Param("uid")int uid, @Param("type")int type, @Param("commit")String commit);

}
