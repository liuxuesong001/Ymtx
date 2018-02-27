package com.lypt.project.ui.ac;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.hpw.mvpframe.utils.helper.RxUtil;
import com.lypt.project.R;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *  huanying ye
 * Created by Administrator on 2017/12/23.
 */

public class WelcomeActivity extends CoreBaseActivity {

    private final int MESSAGE_SUCCESS=1001;

    @BindView(R.id.wel_iv)
    ImageView wel_iv;

    private  int duration = 0;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==MESSAGE_SUCCESS)
            {

                Observable.timer(1000, TimeUnit.MILLISECONDS)
                        .compose(RxPermissions.getInstance(WelcomeActivity.this).ensureEach(
//                        Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.CAMERA,
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.ACCESS_COARSE_LOCATION)
                        )
                        .compose(RxUtil.rxSchedulerHelper())
                        .subscribe(permission -> {
                            if (permission.granted) {
                                startActivity(MainActivity.class);
                                finish();
                            }
                        });
            }
            return false;
        }
    });


    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        StatusBarUtil.transparentStatusBar(this);
        int iv = R.drawable.splash_background;

        Glide.with(this).load(iv).into(wel_iv);

//        Glide.with(this).load(R.drawable.splash_background_gif)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .listener(new RequestListener<Integer, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
////                        // 计算动画时长
//
//                        GifDrawable drawable = (GifDrawable) resource;
//                        GifDecoder decoder = drawable.getDecoder();
//                        for (int i = 0; i < drawable.getFrameCount(); i++) {
//                            duration += decoder.getDelay(i);
//                        }
////                        //发送延时消息，通知动画结束
//                        handler.sendEmptyMessageDelayed(MESSAGE_SUCCESS,duration);
//
//                        return false;
//                    }
//                })
//                .into(new GlideDrawableImageViewTarget(wel_iv,1));

        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(RxPermissions.getInstance(WelcomeActivity.this).ensureEach(
//                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CAMERA,
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                )
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(permission -> {
                    if (permission.granted) {
                        startActivity(MainActivity.class);
                        finish();
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
