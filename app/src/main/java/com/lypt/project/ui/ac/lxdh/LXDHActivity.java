package com.lypt.project.ui.ac.lxdh;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.lypt.project.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * Created by Administrator on 2018/1/11.
 */

public class LXDHActivity extends CoreBaseActivity {
    @BindView(R.id.iv_gif)
    ImageView gif;
    @BindView(R.id.iv_line)
    ImageButton ivBtn;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    String mTabs[]={"观光车","驾车","骑行","步行"};

    int ints[]={R.drawable.ggc_tab_selector,R.drawable.jc_tab_selector,R.drawable.qx_tab_selector};


    @OnClick({R.id.iv_line})
    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.iv_line:
                finish();
                break;
            default:
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_lxdh;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setToolBar(toolbar,"");
        Glide.with(this).load(R.drawable.lx_gif).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(new GlideDrawableImageViewTarget(gif,1));
        for (int i = 0; i < mTabs.length; i++) {
            tabs.addTab(tabs.newTab().setText(mTabs[i]));
            tabs.getTabAt(i).setText(mTabs[i]).setIcon(ints[i]);
        }


    }
}
