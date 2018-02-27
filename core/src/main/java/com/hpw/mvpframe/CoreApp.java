package com.hpw.mvpframe;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.hpw.mvpframe.utils.ACache;
import com.hpw.mvpframe.utils.SpUtil;

/**
 * Created by hpw on 16/10/28.
 */

public abstract class CoreApp extends Application {

    private static CoreApp mApp;

    /**
     * 缓存
     */
    public static ACache cache;


    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
        SpUtil.init(this);
    }

    public static synchronized CoreApp getInstance() {
        return mApp;
    }

    public static Context getAppContext() {
        return mApp.getApplicationContext();
    }

    public static Resources getAppResources() {
        return mApp.getResources();
    }

    public abstract String setBaseUrl();


    public static ACache getCache() {
        if (cache == null) {
            cache = ACache.get(CoreApp.getAppContext());
        }
        return cache;
    }

}
