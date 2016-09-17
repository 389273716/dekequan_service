package com.dekequan.orm.menu;

import java.util.Date;

public class Menu {
    private Integer menuId;                  //菜单ID

    private Date createTime;                  //创建时间

    private String title;                           //标题

    private String tip;                              //小贴士

    private String mainImage;                 //主图（图片标题）

    private Integer viewCount;                 //浏览量

    private Integer userCollectCount;       //用户收藏量

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getUserCollectCount() {
        return userCollectCount;
    }

    public void setUserCollectCount(Integer userCollectCount) {
        this.userCollectCount = userCollectCount;
    }
}