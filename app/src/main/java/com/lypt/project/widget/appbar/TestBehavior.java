package com.lypt.project.widget.appbar;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Administrator on 2018/1/3.
 */

public class TestBehavior  extends AppBarLayout.Behavior {

    private static final int TYPE_FLING = 1;

    private boolean isFlinging;
    private boolean shouldBlockNestedScroll;

    public TestBehavior() {
    }

    public TestBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, AppBarLayout child, MotionEvent ev) {
        Log.i("TestBehavior", "onInterceptTouchEvent:" + child.getTotalScrollRange());
        shouldBlockNestedScroll = false;
        if (isFlinging) {
            shouldBlockNestedScroll = true;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {
        //注意看ViewCompat.TYPE_TOUCH
        Log.i("TestBehavior", "onNestedPreScroll:" + child.getTotalScrollRange() + " ,dx:" + dx + " ,dy:" + dy + " ,type:" + consumed);
        //所以这里监听子类的非touch时的滑动，然后block掉滑动事件传递给AppBarLayout
//        if ( == TYPE_FLING) {
//            isFlinging = true;
//        }

        if (!shouldBlockNestedScroll) {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        }

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (!shouldBlockNestedScroll)
        {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        }
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target) {
        super.onStopNestedScroll(coordinatorLayout, abl, target);
        isFlinging = false;
        shouldBlockNestedScroll = false;
    }

}