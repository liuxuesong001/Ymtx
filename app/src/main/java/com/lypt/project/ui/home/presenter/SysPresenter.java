package com.lypt.project.ui.home.presenter;

import com.lypt.project.ui.home.contract.SysContract;

/**
 * Created by Administrator on 2018/1/16.
 */

public class SysPresenter extends SysContract.SysViewPresenter {


    @Override
    public void onStart()
    {

    }

    @Override
    public void setMsg(String regId) {
        mRxManager.add(mModel.getSysMsg(regId)
                .subscribe(
                        data -> mView.showMsg(data),
                        e -> mView.showError("数据加载失败ヽ(≧Д≦)ノ")
                ));
    }

}
