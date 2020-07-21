package com.caohongchuan.sdurunner.domain;


import java.util.ArrayList;

public class Post implements Comparable{

  private int pid;
  private String nickname;
  private int uid;
  private long duration;
  private long distance;
  private java.sql.Timestamp time;
  private String rgpslist;
  private long permission;
  private String msg;
  private String profilepic;
  private long totaldistance;

  private ArrayList<Reaction> commit = new ArrayList<>();


  public long getTotaldistance() {
    return totaldistance;
  }

  public void setTotaldistance(long totaldistance) {
    this.totaldistance = totaldistance;
  }

  public ArrayList<Reaction> getCommit() {
    return commit;
  }

  public void setCommit(ArrayList<Reaction> commit) {
    this.commit = commit;
  }

  public int compareTo(Object other){
    Post oth = (Post) other;
    if(this.time.before(((Post) other).getTime())){
        return 1;
    }else if(this.time.after(((Post) other).getTime()) ){
        return -1;
    }else{
        return 0;
    }

  }

  public String getProfilepic() {
    return profilepic;
  }

  public void setProfilepic(String profilepic) {
    this.profilepic = profilepic;
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


  public long getDistance() {
    return distance;
  }

  public void setDistance(long distance) {
    this.distance = distance;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getRgpslist() {
    return rgpslist;
  }

  public void setRgpslist(String rgpslist) {
    this.rgpslist = rgpslist;
  }


  public long getPermission() {
    return permission;
  }

  public void setPermission(long permission) {
    this.permission = permission;
  }


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "Post{" +
            "pid=" + pid +
            ", nickname='" + nickname + '\'' +
            ", uid=" + uid +
            ", duration=" + duration +
            ", distance=" + distance +
            ", time=" + time +
            ", rgpslist='" + rgpslist + '\'' +
            ", permission=" + permission +
            ", msg='" + msg + '\'' +
            '}';
  }
}
