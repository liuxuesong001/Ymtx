package com.lypt.project.ui.ac.lyyh.model;

import com.lypt.project.ModelBean;

/**
 * Created by Administrator on 2018/1/2.
 */

public class LYYHBean extends ModelBean
{
    private int img;
    private String name;
    private String pf;
    private String pj;
    private String yj;
    private String zka;
    private String zkb;
    private String zkc;
    private String zj;
    private String jl;

    public LYYHBean(int img, String name, String pf, String pj, String yj, String zka, String zkb, String zkc, String zj, String jl) {
        this.img = img;
        this.name = name;
        this.pf = pf;
        this.pj = pj;
        this.yj = yj;
        this.zka = zka;
        this.zkb = zkb;
        this.zkc = zkc;
        this.zj = zj;
        this.jl = jl;
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

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }

    public String getZka() {
        return zka;
    }

    public void setZka(String zka) {
        this.zka = zka;
    }

    public String getZkb() {
        return zkb;
    }

    public void setZkb(String zkb) {
        this.zkb = zkb;
    }

    public String getZkc() {
        return zkc;
    }

    public void setZkc(String zkc) {
        this.zkc = zkc;
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }

    public String getJl() {
        return jl;
    }

    public void setJl(String jl) {
        this.jl = jl;
    }
}
