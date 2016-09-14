package com.dekequan.orm.user;

/**
 * 用户简单类实体，用于其他模块查询调用
 * @Author 佘俊
 * @Date 2016/9/15 0:29
 * @email shejun1123@163.com
 */
public class SimpleUser {
    private Integer userId;

    private String userName;			//用户名

    private String nickName;			//昵称

    private Integer rank;				//等级

    private String rankName;            //等级名称

    private Integer level;				//会员级别

    private String levelName;           //会员名称

    private String img;					//用户头像

    private Integer sex;				//性别

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
