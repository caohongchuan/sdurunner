package com.caohongchuan.sdurunner.domain;


public class Reaction {

  private long type;
  private long pid;
  private long uid;
  private String nickname;
  private String commit;
  private String profilepic;
  private long distance;


  public long getDistance() {
    return distance;
  }

  public void setDistance(long distance) {
    this.distance = distance;
  }

  public String getProfilepic() {
    return profilepic;
  }

  public void setProfilepic(String profilepic) {
    this.profilepic = profilepic;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getCommit() {
    return commit;
  }

  public void setCommit(String commit) {
    this.commit = commit;
  }

  @Override
  public String toString() {
    return "Reaction{" +
            "type=" + type +
            ", pid=" + pid +
            ", uid=" + uid +
            ", nickname='" + nickname + '\'' +
            ", commit='" + commit + '\'' +
            '}';
  }
}
