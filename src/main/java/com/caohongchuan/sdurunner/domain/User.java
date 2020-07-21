package com.caohongchuan.sdurunner.domain;


public class User {

  private long uid;
  private String nickname;
  private String password;
  private String gender;
  private java.sql.Date birthday;
  private long weight;
  private long height;
  private java.sql.Date regtime;
  private String profilepic;
  private long totaldistance;
  private long totalduration;
  private String rankname;

  public String getRankname() {
    return rankname;
  }

  public void setRankname(String rankname) {
    this.rankname = rankname;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public long getWeight() {
    return weight;
  }

  public void setWeight(long weight) {
    this.weight = weight;
  }


  public long getHeight() {
    return height;
  }

  public void setHeight(long height) {
    this.height = height;
  }


  public java.sql.Date getRegtime() {
    return regtime;
  }

  public void setRegtime(java.sql.Date regtime) {
    this.regtime = regtime;
  }


  public String getProfilepic() {
    return profilepic;
  }

  public void setProfilepic(String profilepic) {
    this.profilepic = profilepic;
  }


  public long getTotaldistance() {
    return totaldistance;
  }

  public void setTotaldistance(long totaldistance) {
    this.totaldistance = totaldistance;
  }


  public long getTotalduration() {
    return totalduration;
  }

  public void setTotalduration(long totalduration) {
    this.totalduration = totalduration;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", nickname='" + nickname + '\'' +
            ", password='" + password + '\'' +
            ", gender='" + gender + '\'' +
            ", birthday=" + birthday +
            ", weight=" + weight +
            ", height=" + height +
            ", regtime=" + regtime +
            ", profilepic='" + profilepic + '\'' +
            ", totaldistance=" + totaldistance +
            ", totalduration=" + totalduration +
            '}';
  }
}
