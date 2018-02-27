package com.lypt.project.ui.fm.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.lypt.project.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/12/28.
 */

public class DingDanFragment extends CoreBaseFragment {

    protected boolean isVisible;

    @BindView(R.id.tabs)
    TabLayout tabs;

    String mTabs[]={"全部","有效单","待支付","退款单"};

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dingdan;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {



        for (int i = 0; i < mTabs.length; i++) {
            tabs.addTab(tabs.newTab().setText(mTabs[i]));
            tabs.getTabAt(i).setText(mTabs[i]);
        }

//        tabs.post(new Runnable() {
//            @Override
//            public void run() {
//                StatusBarUtil.setIndicator(tabs,23,23);
//            }
//        });

    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}
