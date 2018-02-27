package com.lypt.project.ui.ac;

import android.os.Bundle;

import com.lypt.project.App;
import com.lypt.project.R;
import com.lypt.project.ui.fm.MainFragment;

public class MainActivity extends AppMainActivity implements MainFragment.OnBackToFirstListener {



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        if (savedInstanceState==null)
        {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance(0));
        }

    }

    @Override
    public boolean isOpen() {
        return true;
    }


    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    public void onBackToFirstFragment() {
        loadRootFragment(R.id.fl_container, MainFragment.newInstance(0));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getCache().remove("title");
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if (AppUtils.isShouldHideInput(v, ev)) {
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm != null) {
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                }
//            }
//            return super.dispatchTouchEvent(ev);
//        }
//        // 必不可少，否则所有的组件都不会有TouchEvent了
//        if (getWindow().superDispatchTouchEvent(ev)) {
//            return true;
//        }
//        return onTouchEvent(ev);
//    }

//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        // TODO Auto-generated method stub
//        if(onHideKeyboardListener != null){
//            if(ev.getAction() == MotionEvent.ACTION_DOWN){
//                if(onHideKeyboardListener.hideKeyboard()){
//                    return false;  //不在分发触控给子控件
//                }
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }

//    private ArrayList<MyOnTouchListener> onTouchListeners = new ArrayList<MyOnTouchListener>(
//            10);
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        for (MyOnTouchListener listener : onTouchListeners) {
//            listener.onTouch(ev);
//        }
//        return super.dispatchTouchEvent(ev);
//    }
//
//    public void registerMyOnTouchListener(MyOnTouchListener myOnTouchListener) {
//        onTouchListeners.add(myOnTouchListener);
//    }
//
//    public void unregisterMyOnTouchListener(MyOnTouchListener myOnTouchListener) {
//        onTouchListeners.remove(myOnTouchListener);
//    }
//
//    public interface MyOnTouchListener {
//        public boolean onTouch(MotionEvent ev);
//    }

}
