package com.lypt.project;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.baidu.mapapi.SDKInitializer;
import com.hpw.mvpframe.CoreApp;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

import cn.jpush.android.api.JPushInterface;

/**
 *
 * Created by Administrator on 2017/12/23.
 */

public class App extends CoreApp {


    @Override
    public String setBaseUrl() {
        return "http://192.168.0.103";
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this, "5a697d7ff43e4861cb0001ec", "ymt", MobclickAgent.EScenarioType.E_UM_NORMAL, true));
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
//        Bugly.init(getApplicationContext(), "e0bec44741", true);
//        CrashReport.initCrashReport(getApplicationContext());
        CrashReport.initCrashReport(getApplicationContext(), "01608151f9", true);
    }

}
