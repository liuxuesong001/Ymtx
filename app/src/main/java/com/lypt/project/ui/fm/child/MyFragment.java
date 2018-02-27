package com.lypt.project.ui.fm.child;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.hpw.mvpframe.utils.StringUtils;
import com.lypt.project.R;
import com.lypt.project.widget.appbar.AppBarStateChangeListener;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/12/28.
 */

public class MyFragment extends CoreBaseFragment{

    @BindView(R.id.ivBj)
    ImageView ivBj;




    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
//        int iv = R.drawable.my_bjt;
//        Glide.with(this).load(iv).into(ivBj);


    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}
