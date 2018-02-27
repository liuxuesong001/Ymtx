package com.lypt.project.widget.editview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hpw.mvpframe.utils.AppUtils;
import com.lypt.project.R;


/**
 * 自定义SearchView
 * Created by Administrator on 2018/1/29.
 */

public class SearchViewEditText extends LinearLayout implements TextWatcher,View.OnClickListener {


    /**
     * 输入框
     */
    private EditText et_search;
    /**
     * 输入框后面的那个清除按钮
     */
    private Button bt_clear;

    private String mHint;




    public SearchViewEditText(Context context) {
        this(context,null);

    }


    /**
     * 设置Hint文字
     * @param hintValue
     */
    public void setMyHint(String hintValue){
        this.mHint=hintValue;
        et_search.setHint(mHint);
        this.postInvalidate();
    }

    /**
     * 是否显示光标
     * @param e
     */
    public void isCursorVisible(boolean e)
    {
        if (et_search.hasFocus())
        {
            et_search.setCursorVisible(e);
            //隐藏软键盘
            AppUtils.hideSoftInput(et_search);
        }
    }


    public SearchViewEditText(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SearchViewEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.layout_searchview, this, true);
        /***找出控件*/
        et_search = (EditText) findViewById(R.id.et_search);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        bt_clear.setVisibility(GONE);
        et_search.addTextChangedListener(this);
        bt_clear.setOnClickListener(this);
        et_search.setOnClickListener(this);
//        et_search.setHint(mHint);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    @Override
    public void afterTextChanged(Editable s) {
        /**获取输入文字**/
        String input = et_search.getText().toString().trim();
        if (input.isEmpty()) {
            bt_clear.setVisibility(GONE);
        } else {
            bt_clear.setVisibility(VISIBLE);
        }

    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.et_search:
                et_search.setCursorVisible(true);
                break;
            case R.id.bt_clear:
                et_search.setText("");
                break;
            default:
        }
    }



//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = mContext.getCurrentFocus();
//            if (isShouldHideInput(v, ev)) {
//
//                InputMethodManager imm = (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm != null) {
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                }
//            }
//            return super.dispatchTouchEvent(ev);
//        }
//        // 必不可少，否则所有的组件都不会有TouchEvent了
//        if (mContext.getWindow().superDispatchTouchEvent(ev)) {
//            return true;
//        }
//        return onTouchEvent(ev);
//    }
//
//    public  boolean isShouldHideInput(View v, MotionEvent event) {
//        if (v != null && (v instanceof EditText)) {
//            int[] leftTop = { 0, 0 };
//            //获取输入框当前的location位置
//            v.getLocationInWindow(leftTop);
//            int left = leftTop[0];
//            int top = leftTop[1];
//            int bottom = top + v.getHeight();
//            int right = left + v.getWidth();
//            if (event.getX() > left && event.getX() < right
//                    && event.getY() > top && event.getY() < bottom) {
//                // 点击的是输入框区域，保留点击EditText的事件
//                return false;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }


//    @Override
//    protected void onDetachedFromWindow() {
//        et_search.setCursorVisible(false);
//        super.onDetachedFromWindow();
//    }
}

