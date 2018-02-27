package com.lypt.project.mvp.presenter;

import com.lypt.project.mvp.contract.HomeContract;

/**
 * Created by Administrator on 2017/12/28.
 */

public class HomePresenter extends HomeContract.HomePresenter{

    @Override
    public void getTabList() {
        mView.showTabList(mModel.getTabs(),mModel.getTabsIcon());
    }

    @Override
    public void onStart() {
        getTabList();
    }
}
