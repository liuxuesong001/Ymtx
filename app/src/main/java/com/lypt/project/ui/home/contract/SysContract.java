package com.lypt.project.ui.home.contract;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;
import com.lypt.project.ui.home.entity.SysBean;

import rx.Observable;

/**
 * Created by Administrator on 2018/1/16.
 */

public interface SysContract {

    interface SysModel extends CoreBaseModel {

        Observable<SysBean>getSysMsg(String regId);

    }

    interface SysView extends CoreBaseView {
        void showMsg(SysBean bean);
    }

    abstract class SysViewPresenter extends CoreBasePresenter<SysModel, SysView> {
        public abstract void setMsg(String regId);

    }
}
