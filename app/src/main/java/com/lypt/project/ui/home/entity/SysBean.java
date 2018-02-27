package com.lypt.project.ui.home.entity;

import com.lypt.project.ModelBean;

/**
 * Created by Administrator on 2018/1/16.
 */

public class SysBean extends ModelBean {


    /**
     * title : TEST
     * description : 扫码成功！！
     */

    private String msg;
    private String error;
    private String title;
    private String description;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
