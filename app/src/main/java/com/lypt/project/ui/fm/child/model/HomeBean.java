package com.lypt.project.ui.fm.child.model;

import com.lypt.project.ModelBean;

/**
 * Created by Administrator on 2018/1/5.
 */

public class HomeBean extends ModelBean {

    private int img;
    private String name;
    private String content;
    private String xh;
    private String pf;
    private String yj;
    private String zj;

    public HomeBean(int img, String name, String content, String xh, String pf, String yj, String zj) {
        this.img = img;
        this.name = name;
        this.content = content;
        this.xh = xh;
        this.pf = pf;
        this.yj = yj;
        this.zj = zj;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }
}
