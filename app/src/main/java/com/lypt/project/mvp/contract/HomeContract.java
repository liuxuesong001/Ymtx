package com.lypt.project.mvp.contract;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

/**
 * Created by Administrator on 2017/12/28.
 */

public interface HomeContract {


    //主页接口
    abstract class HomePresenter extends CoreBasePresenter<HomeModel, HomeView> {
        public abstract void getTabList();
    }

    interface HomeModel extends CoreBaseModel {
        String[] getTabs();
        int [] getTabsIcon();
    }

    interface HomeView extends CoreBaseView {
        void showTabList(String[] mTabs,int[] mInts);
    }


}
