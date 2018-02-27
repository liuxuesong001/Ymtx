package com.lypt.project.ui.ac;

import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.hpw.mvpframe.base.CoreBaseActivity;

/**
 * Created by Administrator on 2018/2/1.
 */

public abstract class  AppMainActivity extends CoreBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
    }
}
