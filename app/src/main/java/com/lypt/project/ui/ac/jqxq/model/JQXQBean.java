package com.lypt.project.ui.ac.jqxq.model;

import com.lypt.project.ModelBean;

/**
 * Created by Administrator on 2018/1/2.
 */

public class JQXQBean extends ModelBean
{
    private String title;
    private String xj;
    private String btna;
    private String btnb;
    private String yj;
    private String gptime;
    private int ydstate;

    public String getTitle() {
        return title;
    }

    public String getXj() {
        return xj;
    }

    public String getBtna() {
        return btna;
    }

    public String getBtnb() {
        return btnb;
    }

    public String getYj() {
        return yj;
    }

    public String getGptime() {
        return gptime;
    }

    public int getYdstate() {
        return ydstate;
    }

    public JQXQBean(String title, String xj, String btna, String btnb, String yj, String gptime, int ydstate) {
        this.title = title;
        this.xj = xj;
        this.btna = btna;
        this.btnb = btnb;
        this.yj = yj;
        this.gptime = gptime;
        this.ydstate = ydstate;
    }
}
