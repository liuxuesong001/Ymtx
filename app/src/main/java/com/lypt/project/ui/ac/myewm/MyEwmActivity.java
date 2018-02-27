package com.lypt.project.ui.ac.myewm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.utils.ZXingUtils;
import com.hpw.mvpframe.CoreApp;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.hpw.mvpframe.utils.StringUtils;
import com.lypt.project.R;
import com.lypt.project.push.Constants;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/5.
 */

public class MyEwmActivity extends CoreBaseActivity {

    @BindView(R.id.toolbar_myewm)
    Toolbar mToolbar;

    @BindView(R.id.iv_ewm)
    ImageView ivEwm;
    @BindView(R.id.ypcg_iv)
    ImageView Tpcg;
//    @BindView(R.id.ypcg_jjm)
//    ImageView ivJjM;



    @BindView(R.id.iv_ma)
    ImageView ivMa;

    private MessageReceiver mMessageReceiver;


    @OnClick({R.id.home_back})
    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.home_back:
                onBackPressedSupport();
                break;
            default:
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_myewm;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
//        StatusBarUtil.setColor(this, CoreApp.getAppResources().getColor(R.color.tabSelectedTextColor));
//        setToolBar(mToolbar,"");
        createQRImage();
//        createQRJJImage();
//        if (CoreApp.getCache().getAsString("title")!=null&&App.getCache().getAsString("title").equals("一码通"))
//        {
//            Tpcg.setVisibility(View.VISIBLE);
//            Tpcg.bringToFront();
//        }
//        if (savedInstanceState!=null)
//        {
//            boolean state=savedInstanceState.getBoolean("push");
//            if (state)
//            {
//                Tpcg.setVisibility(View.VISIBLE);
//                Tpcg.bringToFront();
//            }
//        }

//        llBtn.bringToFront();
        int ma =R.drawable.iv_ma;
        Glide.with(this).load(ma).into(ivMa);
        mToolbar.bringToFront();


    }

    /**
     * 讲解码
     */
    private void createQRJJImage() {

        String str="讲解码";
        Bitmap logo = BitmapFactory.decodeResource(CoreApp.getAppResources(),R.drawable.lypt_launcher);
        if (logo!=null)
        {
            Bitmap qrImage = ZXingUtils.createQRCodeWithLogo(str, logo);
            if (qrImage != null) {
//                ivJjM.setImageBitmap(qrImage);
            } else {
                Toast.makeText(this, "生成失败", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerMessageReceiver();
    }


    /**
     * 生成二维码
     */
    public void createQRImage() {

//        String str=CoreApp.getCache().getAsString("regId");
        String str="演示对话框";
        if (str!=null)
        {
            Bitmap logo = BitmapFactory.decodeResource(CoreApp.getAppResources(),R.drawable.lypt_launcher);
            if (logo!=null)
            {
                Bitmap qrImage = ZXingUtils.createQRCodeWithLogo(str, logo);
                if (qrImage != null) {
                    ivEwm.setImageBitmap(qrImage);
                } else {
                    Toast.makeText(this, "生成失败", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }

    @Override
    public boolean isOpen() {
        return false;
    }

    private class MessageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (Constants.MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(Constants.KEY_MESSAGE);
                    String extras = intent.getStringExtra(Constants.KEY_EXTRAS);
//                    StringBuilder showMsg = new StringBuilder();
//                    showMsg.append(Constants.KEY_MESSAGE + " : " + messge + "\n");
                    if (!StringUtils.isEmpty(extras))
                    {
                        Tpcg.setVisibility(View.VISIBLE);
                        Tpcg.bringToFront();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);

    }
    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(Constants.MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }
    /**
     * 扫一扫
     */
    public void scanCode() {
        Intent intent = new Intent(this, CaptureActivity.class);
        //是否显示相册按钮
        intent.putExtra(CaptureActivity.INTENT_KEY_PHOTO_FLAG, true);
        //识别声音
        intent.putExtra(CaptureActivity.INTENT_KEY_BEEP_FLAG, true);
        //识别震动
        intent.putExtra(CaptureActivity.INTENT_KEY_VIBRATE_FLAG, true);
        //扫码框的颜色
        intent.putExtra(CaptureActivity.INTENT_KEY_SCSNCOLOR, "#FFFF00");
        //扫码框上面的提示文案
        intent.putExtra(CaptureActivity.INTENT_KEY_HINTTEXT, "请将二维码放入框中....");
        startActivityForResult(intent, 1000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (data == null) {
                return;
            }
            switch (resultCode) {
                case CaptureActivity.RESULT_SUCCESS:
                    String resultSuccess = data.getStringExtra(CaptureActivity.INTENT_KEY_RESULT_SUCCESS);
//                    textView.setText(resultSuccess);
                    if (resultSuccess != null) {
//                        对话框(resultSuccess);
//                        mPresenter.setMsg(resultSuccess);

                    }

                    break;
                case CaptureActivity.RESULT_FAIL:
                    String resultError = data.getStringExtra(CaptureActivity.INTENT_KEY_RESULT_ERROR);
                    showToast(resultError);
                    break;
                case CaptureActivity.RESULT_CANCLE:
                    showToast("取消扫码");
                    break;
                default:
            }
        }
    }

    public void 对话框(String content) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("信息");
        alertDialog.setMessage(content);
        alertDialog.setPositiveButton("点击返回页", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

}
