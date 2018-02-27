package com.lypt.project.ui.fm;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.helper.FragmentAdapter;
import com.lypt.project.Constants;
import com.lypt.project.R;
import com.lypt.project.mvp.contract.HomeContract;
import com.lypt.project.mvp.model.HomeModel;
import com.lypt.project.mvp.presenter.HomePresenter;
import com.lypt.project.ui.fm.child.DaoHangFragment;
import com.lypt.project.ui.fm.child.DingDanFragment;
import com.lypt.project.ui.fm.child.HomeFragment;
import com.lypt.project.ui.fm.child.MyFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 * Created by Administrator on 2017/12/28.
 */

public class MainFragment extends CoreBaseFragment<HomePresenter,HomeModel>implements HomeContract.HomeView,ViewPager.OnPageChangeListener{


    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    List<Fragment> fragments = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    public static MainFragment newInstance(int position) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.ARG_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void showTabList(String[] mTabs,int[] ints) {
        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序
        for (int i = 0; i < mTabs.length; i++) {
            tabs.addTab(tabs.newTab().setText(mTabs[i]));
            switch (i) {
                case 0:
                    fragments.add(new HomeFragment());
                    break;
                case 1:
                    fragments.add(new DaoHangFragment());
                    break;
                case 2:
                    fragments.add(new DingDanFragment());
                    break;
                default:
                    fragments.add(new MyFragment());
                    break;
            }
        }
        int position = getArguments().getInt(Constants.ARG_POSITION, 1);
        viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        //要设置到viewpager.setAdapter后才起作用
        viewpager.setCurrentItem(position);
        tabs.setupWithViewPager(viewpager);
        tabs.setVerticalScrollbarPosition(position);
        for (int i = 0; i < mTabs.length; i++) {
//            tabs.getTabAt(i).setText(mTabs[i]).setIcon(ints[i]);
            TabLayout.Tab tab = tabs.getTabAt(i).setText(mTabs[i]).setIcon(ints[i]);
            tab.setCustomView(R.layout.view_home_tab);

        }
//        setIndicator(tabs,20,20);
    }

    @Override
    public void showError(String msg) {

    }

    /**
     *
     * @param tabs
     * @param leftDip
     * @param rightDip
     */
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());
        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
