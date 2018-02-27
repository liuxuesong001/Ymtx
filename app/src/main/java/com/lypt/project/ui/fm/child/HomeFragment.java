package com.lypt.project.ui.fm.child;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.zxing.client.android.CaptureActivity;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.DialogUtils;
import com.lypt.project.R;
import com.lypt.project.ui.ac.lyyh.LYYHActivity;
import com.lypt.project.ui.ac.mpgm.MPGMAvtivity;
import com.lypt.project.ui.ac.myewm.MyEwmActivity;
import com.lypt.project.ui.ac.tssp.TSSPActivity;
import com.lypt.project.ui.fm.child.adapter.HomeAdapter;
import com.lypt.project.ui.fm.child.model.HomeBean;
import com.lypt.project.ui.home.contract.SysContract;
import com.lypt.project.ui.home.entity.SysBean;
import com.lypt.project.ui.home.model.SysModel;
import com.lypt.project.ui.home.presenter.SysPresenter;
import com.lypt.project.widget.GlideImageLoader;
import com.lypt.project.widget.editview.SearchViewEditText;
import com.socks.library.KLog;
import com.umeng.analytics.MobclickAgent;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.byteam.superadapter.OnItemDataClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * Created by Administrator on 2017/12/28.
 */

public class HomeFragment extends CoreBaseFragment<SysPresenter,SysModel> implements SysContract.SysView,NestedScrollView.OnScrollChangeListener
{


    private String pageName;

    @BindView(R.id.banner)
    Banner banner;


    @BindView(R.id.mpgm)
    LinearLayout mpgm;
    @BindView(R.id.sys)
    LinearLayout sysLL;
    @BindView(R.id.ewm)
    LinearLayout ewmLL;
    @BindView(R.id.xiaoxi)
    ImageButton xiaoxiBtn;
    @BindView(R.id.tssp)
    LinearLayout tssp;
    @BindView(R.id.lyyh)
    LinearLayout lyyh;
//    @BindView(R.id.jdyd)
//    LinearLayout jdyd;

//    @BindView(R.id.home_gridview)
//    MyGridView gridView;

    @BindView(R.id.rv_home)
    RecyclerView rv_home;

    @BindView(R.id.home_sousuo_ll)
    LinearLayout sousuoLL;

    //    @BindView(R.id.et_search)
//    EditText ed_Search;
    @BindView(R.id.nestScrView)
    NestedScrollView nestedScrollView;
//    me.henrytao.smoothappbarlayout.widget.NestedScrollView nestedScrollView;
//    ScrollviewNestedRecyclerview nestedScrollView;

    @BindView(R.id.editser)
    SearchViewEditText editSer;

    @BindView(R.id.toolbar_jqxq)
    Toolbar toolbar;
//
//    @BindView(R.id.appBarLayout)
//    AppBarLayout mArrLayout;


//    @BindView(R.id.collapsing_toolbar)
//    CollapsingToolbarLayout cool;


    private HomeAdapter mAdapter;


    private  LinearLayoutManager layoutManager;


//    private MainActivity.OnHideKeyboardListener onHideKeyboardListener;

//    private InputMethodManager methodManager;
//    MainActivity.MyOnTouchListener myOnTouchListener;
//    private GestureDetector mGestureDetector;

    private boolean isZhedie = false;



    @OnClick({R.id.sys, R.id.ewm})
    public void onClick(LinearLayout v) {
        switch (v.getId()) {
            case R.id.sys:
                scanCode();
                break;
            case R.id.ewm:
                startActivity(new Intent(getActivity(), MyEwmActivity.class));
                break;
            default:
        }
    }

    public HomeFragment(){
        pageName=getClass().getName();
    }

    List<Integer> banr = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }




    @SuppressLint("NewApi")
    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar.bringToFront();
//        ViewColor.setColor(getActivity(), R.color.tabSelectedTextColor); // 设置沉浸式状态栏的代码，布局里面需要添加
//        sousuoLL.bringToFront();
        banr.add(R.drawable.banner_a);
        banr.add(R.drawable.banner_b);
        banr.add(R.drawable.banner_c);
        banr.add(R.drawable.banner_d);

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(banr);
        //设置banner动画效果
        banner.setBannerAnimation(com.youth.banner.Transformer.CubeOut);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        layoutManager = new org.solovyev.android.views.llm.LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_home.setLayoutManager(layoutManager);
        List<HomeBean> list = new ArrayList<>();
        list.add(new HomeBean(R.drawable.gsbz_a, "当季精选·古水北镇", "购古水北镇门票赠送司马台长城门票", "9,253", "6.253", "150", "140"));
        list.add(new HomeBean(R.drawable.gg_a, "原创景泰蓝镶钻 古典宫廷风故宫纪念品", "唐马仕景泰蓝金属书签阿哥格格故宫纪念品中国", "1,086", "820", "260", "120"));
        list.add(new HomeBean(R.drawable.ykt_a, "京津冀旅游一卡通", "享京津冀158景区8折旅游优惠，部分景区免费游览", "8,689", "1,589", "230", "200"));
        list.add(new HomeBean(R.drawable.dlt_a, "人文建筑游览套票", "天安门广场+故宫+天坛+八达岭长城", "4,669", "3,286", "200", "180"));
        mAdapter = new HomeAdapter(getActivity(), list, R.layout.item_home_content);
        rv_home.setFocusable(false);
        rv_home.setHasFixedSize(false);
        rv_home.setNestedScrollingEnabled(false);
        rv_home.setAdapter(mAdapter);

        mAdapter.setOnItemDataClickListener(new OnItemDataClickListener<HomeBean>() {
            @Override
            public void onItemClick(View itemView, int viewType, int position, List<HomeBean> data) {
                showToast(mAdapter.getData().get(position).getName());
            }
        });

        editSer.setMyHint("颐和园");

//
//        mArrLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
//            @Override
//            public void onStateChanged(AppBarLayout appBarLayout, State state) {
////                Log.d("STATE", state.name());
//                if (state == State.EXPANDED) {
//                    //展开状态
//                    toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(android.R.color.transparent));
//                    KLog.d("mArrLayout 展开状态");
//                } else if (state == State.COLLAPSED) {
//                    //折叠状态
//                    KLog.d("mArrLayout 折叠状态");
//                    isZhedie=true;
//                    toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(R.color.tabSelectedTextColor));
//                } else {
//                    //中间
//                    KLog.d("mArrLayout 中间状态");
//                }
//            }
//        });

//        //view重绘时回调
//        view.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
//            @Override
//            public void onDraw() {
//                DisplayMetrics displaymetrics = new DisplayMetrics();
//                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//                int screenHeight = displaymetrics.heightPixels;
//                KLog.a("view重绘时回调 高度:"+screenHeight);
//            }
//        });
//
//        //view加载完成时回调
//        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                // TODO Auto-generated method stub
//                DisplayMetrics displaymetrics = new DisplayMetrics();
//                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//                int screenHeight = displaymetrics.heightPixels;
//                KLog.a("view加载完成时回调 高度:"+screenHeight);
//            }
//        });



//        mGestureDetector  = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener());
//
//        myOnTouchListener = new MainActivity.MyOnTouchListener() {
//            @Override
//            public boolean onTouch(MotionEvent ev) {
//                boolean result = mGestureDetector.onTouchEvent(ev);
//                float curY = 0;
//                float prevY = 0;
//                switch (ev.getAction()& MotionEvent.ACTION_MASK)
//                {
//                    case  MotionEvent.ACTION_DOWN:
//                        prevY = ev.getY();
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        curY = ev.getY();
//                        if(curY - prevY < -10){
//
//                        }
//                        return true;
//                    case MotionEvent.ACTION_MOVE:
//                        return true;
//                    default:
//                }
//                return result;
//            }
//        };
//        ((MainActivity) getActivity()).registerMyOnTouchListener(myOnTouchListener);

        nestedScrollView.setOnScrollChangeListener(this);
        ;
    }

    //(x,y)是否在view的区域内
//    private boolean isTouchPointInView(View view, int x, int y) {
//        if (view == null) {
//            return false;
//        }
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        int left = location[0];
//        int top = location[1];
//        int right = left + view.getMeasuredWidth();
//        int bottom = top + view.getMeasuredHeight();
//        //view.isClickable() &&
//        if (y >= top && y <= bottom && x >= left
//                && x <= right) {
//            return true;
//        }
//        return false;
//    }
    @Override
    public View getLayoutView() {
        return super.getLayoutView();
    }


    @Override
    public void onPause() {
        super.onPause();
        if(getUserVisibleHint()){
            onVisibilityChangedToUser(false, false);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if (banner!=null)
        {
            banner.stopAutoPlay();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

//
//    @Override
//    public void OnBannerClick(int position) {
//
//    }


    @OnClick({R.id.mpgm,R.id.tssp,R.id.lyyh})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.mpgm:
                intent = new Intent(getActivity(), MPGMAvtivity.class);
                startActivity(intent);
                break;
            case R.id.tssp:
                intent = new Intent(getActivity(), TSSPActivity.class);
                startActivity(intent);
                break;
            case R.id.lyyh:
                intent = new Intent(getActivity(), LYYHActivity.class);
                startActivity(intent);
                break;
//            case R.id.jdyd:
//                intent = new Intent(getActivity(), JDYDActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.et_search:
//                ed_Search.setCursorVisible(true);
//                break;
            default:
        }
    }

    /**
     * 扫一扫
     */
    public void scanCode() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
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
                        对话框(resultSuccess);
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
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("信息");
        alertDialog.setMessage(content);
        alertDialog.setPositiveButton("点击返回主页", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getUserVisibleHint()){
            onVisibilityChangedToUser(true, false);
        }
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isResumed()){
            onVisibilityChangedToUser(isVisibleToUser, true);
        }
    }

    /**
     * 当Fragment对用户的可见性发生了改变的时候就会回调此方法
     * @param isVisibleToUser true：用户能看见当前Fragment；false：用户看不见当前Fragment
     * @param isHappenedInSetUserVisibleHintMethod true：本次回调发生在setUserVisibleHintMethod方法里；false：发生在onResume或onPause方法里
     */
    public void onVisibilityChangedToUser(boolean isVisibleToUser, boolean isHappenedInSetUserVisibleHintMethod){
        if(isVisibleToUser){
            if(pageName != null){
                MobclickAgent.onPageStart(pageName);
//                Log.i("UmengPageTrack", pageName + " - display - "+(isHappenedInSetUserVisibleHintMethod?"setUserVisibleHint":"onResume"));
            }
        }else{
            if(pageName != null){
                MobclickAgent.onPageEnd(pageName);
//                Log.w("UmengPageTrack", pageName + " - hidden - "+(isHappenedInSetUserVisibleHintMethod?"setUserVisibleHint":"onPause"));
            }
        }
    }

    @Override
    public void showError(String msg) {
        KLog.e(msg);
    }

    @Override
    public void showMsg(SysBean bean) {

        if (bean!=null) {
            if (bean.getTitle() != null) {
                DialogUtils.showConfirmDialog(getActivity(), bean.getTitle(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

            } else if (bean.getError() != null) {
                DialogUtils.showConfirmDialog(getActivity(), bean.getError(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
            }
        }
    }


    private boolean isWu() {
        //获取当前屏幕内容的高度
        int screenHeight = getActivity().getWindow().getDecorView().getHeight();
        //获取View可见区域的bottom
        Rect rect = new Rect();
        getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        return screenHeight - rect.bottom != 0;
    }

    private boolean isYou() {
        //获取当前屏幕内容的高度
        int screenHeight =getSoftButtonsBarHeight();
        //获取View可见区域的bottom
        Rect rect = new Rect();
        getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        return screenHeight - rect.bottom != 0;
    }
    /**
     * 底部虚拟按键栏的高度
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private int getSoftButtonsBarHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        //这个方法获取可能不是真实屏幕的高度
//        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;
        //获取当前屏幕的真实高度
        mActivity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        int realHeight = metrics.heightPixels;
        if (realHeight > usableHeight) {
            return realHeight - usableHeight;
        } else {
            return 0;
        }
    }


    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();

    }



    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        // 将透明度声明成局部变量用于判断
        int alpha = 0;
        int count = 0;
        float scale = 0;
//        final int height = v.getLayoutParams().height*2;
        final int height = banner.getHeight();


//        if (scrollY > height) {
//            scrollY = height;   //当滑动到指定位置之后设置颜色为纯色，之前的话要渐变---实现下面的公式即可
//        }
//        toolbar.setAlpha(scrollY * (END_ALPHA - START_ALPHA) / height + START_ALPHA);

        if (scrollY > oldScrollY) {
//         向下滑动

//            toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(R.color.tabSelectedTextColor));
            editSer.isCursorVisible(false);


        }
//
//        if (scrollY < oldScrollY) {
        // 向上滑动
//        }

//        if (scrollY == 0) {
        // 顶部
//            if (alpha < 255) {
//                KLog.e("执行次数", "=" + (++count));
//                // 防止频繁重复设置相同的值影响性能
//                alpha = 255;
//                toolbar.setBackgroundColor(Color.argb(alpha, 255, 0, 0));
//            }
//            toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(android.R.color.transparent));


//        }
//
////        if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
////            // 底部
////        }

        if (scrollY <= height) {
            scale = (float) scrollY / height;
            alpha = (int) (255 * scale);
            // 随着滑动距离改变透明度
            // Log.e("al=","="+alpha);
            toolbar.setBackgroundColor(Color.argb(alpha, 3, 194, 217));
        } else {
            if (alpha < 255) {
                // 防止频繁重复设置相同的值影响性能
                alpha = 255;
                toolbar.setBackgroundColor(Color.argb(alpha,3, 194, 217));
//                toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(android.R.color.transparent));
            }
        }

    }

//    @Override
//    public void onAttach(Activity activity) {
    // TODO Auto-generated method stub
//        MainActivity.OnHideKeyboardListener onHideKeyboardListener = new MainActivity.OnHideKeyboardListener() {
//            @Override
//            public boolean hideKeyboard() {
//                // TODO Auto-generated method stub
//                if(inputMethodManager.isActive(searchEditText)){
//                    getView().requestFocus();
//                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//                    return true;
//                }
//                return false;
//            }
//        };
//        getActivity().setOnHideKeyboardListener(onHideKeyboardListener);
//        onHideKeyboardListener = new MainActivity.OnHideKeyboardListener() {
//            @Override
//            public boolean hideKeyboard() {
//                methodManager = (InputMethodManager) editSer.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (methodManager.isActive(editSer))
//                {
//                    getView().requestFocus();
//                    methodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//                    return true;
//                }
//                return false;
//            }
//        };
//        ((HomeFragment)getActivity()).setOnHideKeyboardListener(onHideKeyboardListener);
//        super.onAttach(activity);
//    }

//        ed_Search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {//点击软键盘完成控件时触发的行为
//                    //关闭光标并且关闭软键盘
//                    ed_Search.setCursorVisible(false);
//                    AppUtils.hideSoftInput(ed_Search);
//                }
//                return true;//消费掉该行为
//            }
//        });

//        myOnTouchListener = new MyOnTouchListener() {
//            @Override
//            public boolean onTouch(MotionEvent ev) {
//                return false;
//            }
//        };
//        ((MainActivity) getActivity()).registerMyOnTouchListener(myOnTouchListener);

}
