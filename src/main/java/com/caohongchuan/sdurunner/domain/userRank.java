package com.caohongchuan.sdurunner.domain;

public class userRank implements Comparable{
    private int uid;
    private String name;
    private long rundistance;
    private String profilepic;

    public userRank(int uid, String name, long rundistance, String profilepic) {
        this.uid = uid;
        this.name = name;
        this.rundistance = rundistance;
        this.profilepic = profilepic;
    }

    public int compareTo(Object oth){

        userRank other = (userRank) oth;
        if(this.rundistance < other.getRundistance()){
            return 1;
        }else if(this.rundistance > other.getRundistance()){
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRundistance() {
        return rundistance;
    }

    public void setRundistance(long rundistance) {
        this.rundistance = rundistance;
    }

    @Override
    public String toString() {
        return "userRank{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", rundistance=" + rundistance +
                '}';
    }
}
