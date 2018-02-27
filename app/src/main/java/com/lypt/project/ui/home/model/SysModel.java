package com.lypt.project.ui.home.model;

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;
import com.lypt.project.api.YmtApi;
import com.lypt.project.ui.home.contract.SysContract;
import com.lypt.project.ui.home.entity.SysBean;

import rx.Observable;

/**
 *
 * @author Administrator
 * @date 2018/1/16
 */

public class SysModel implements SysContract.SysModel {

    @Override
    public Observable<SysBean> getSysMsg(String regId) {
        return RxService.createApi(YmtApi.class).getData(regId).compose(RxUtil.rxSchedulerHelper());
    }
}
