package com.lypt.project.widget.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2018/2/6.
 */

public class NonTouchableCoordinatorLayout extends CoordinatorLayout {
    public NonTouchableCoordinatorLayout(Context context) {
        super(context);
    }

    public NonTouchableCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonTouchableCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean getTouchscreenBlocksFocus() {
        return false;
    }
}
