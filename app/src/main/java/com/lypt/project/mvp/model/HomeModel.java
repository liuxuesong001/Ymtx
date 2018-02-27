package com.lypt.project.mvp.model;

import com.lypt.project.R;
import com.lypt.project.mvp.contract.HomeContract;

/**
 *
 * Created by Administrator on 2017/12/28.
 */

public class HomeModel implements HomeContract.HomeModel {
    @Override
    public String[] getTabs() {
        String [] tabs={"首页","导航","订单","我的"};
        return tabs;
    }

    @Override
    public int[] getTabsIcon() {
        int [] icons={R.drawable.home_selector,R.drawable.dh_selector,R.drawable.dd_selector,R.drawable.my_selector};
        return icons;
    }
}
