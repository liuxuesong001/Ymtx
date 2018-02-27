package com.lypt.project.ui.ac.jqxq;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.CoreApp;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.lypt.project.R;
import com.lypt.project.ui.ac.jqxq.adapter.JQXQAdapter;
import com.lypt.project.ui.ac.jqxq.adapter.JQXQAdapterA;
import com.lypt.project.ui.ac.mpgm.model.MpgmBean;
import com.lypt.project.widget.appbar.AppBarStateChangeListener;
import com.lypt.project.widget.gridview.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/2.
 */

public class JQXQActivity extends CoreBaseActivity  {

    @BindView(R.id.toolbar_jqxq)
    Toolbar toolbar;

//    @BindView(R.id.banner)
//    Banner banner;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCoolToolbar;

    @BindView(R.id.tv_name)
    TextView tv_name;

    @BindView(R.id.tv_pf)
    TextView tv_pf;

    @BindView(R.id.appBarLayout)
    AppBarLayout mArrLayout;

    List<Integer> banr= new ArrayList<>();

    @BindView(R.id.tag_ll)
    LinearLayout tagLL;

    @BindView(R.id.jqxq_address_ll)
    LinearLayout addReLL;

    @BindView(R.id.jqxq_address)
    TextView tvAddress;


//    @BindView(R.id.rcView_jqxq)
//    RecyclerView rcView;

    @BindView(R.id.jqxq_tv_pj)
    TextView tv_Pj;

    @BindView(R.id.jqxq_tv_zk_a)
    TextView tv_Zka;
    @BindView(R.id.jqxq_tv_zk_b)
    TextView tv_Zkb;

    @BindView(R.id.jqxq_tv_yj)
    TextView tv_yj;
    @BindView(R.id.jqxq_tv_zj)
    TextView tv_zj;

    @BindView(R.id.jqxq_tv_zk_c)
    TextView tv_Zkc;

    @BindView(R.id.home_back)
    ImageView back;
    @BindView(R.id.banner_jqxq)
    ImageView ivBan;

    @BindView(R.id.jqxq_gridview)
    MyGridView myGridView;



    private JQXQAdapter mAdapter;

    private JQXQAdapterA mAdapterA;

    private DividerItemDecoration mDivider;

    private  List<MpgmBean> lists =new ArrayList<>();

    @BindView(R.id.title_jxtj)
    TextView title;

    @BindView(R.id.title_jxtj_tp)
    TextView tptv;

    @BindView(R.id.jxtj_item_zj)
    TextView zjtv;

    @BindView(R.id.jxtj_d)
    TextView yjtv;

    @BindView(R.id.e_tv)
    TextView eTv;

    @BindView(R.id.f_tv)
    TextView fTv;

    @BindView(R.id.g_tv)
    TextView gTv;

    @BindView(R.id.h_tv)
    TextView hTv;




    @BindView(R.id.cool_title)
    TextView coolTvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_jqxq;
    }

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
    public void initView(Bundle savedInstanceState) {


//        banner.setImages(banr)
//                .setImageLoader(new GlideImageLoader())
//                .setOnBannerListener(this)
//                .start();
        initData();
        initViews();
        initAdapter();
    }

    private void initAdapter()
    {
//        mAdapter = new JQXQAdapter(this,null,R.layout.item_jqxq_content);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rcView.setLayoutManager(layoutManager);
//
//        List<JQXQBean> lists=new ArrayList<>();
//        lists.add(new JQXQBean("【电子导游】北京市南锣鼓巷门票","¥20","北京市一卡通","朝阳区一卡通","120","12:00 前可预定今日票",0));
//        lists.add(new JQXQBean("【电子导游】北京市故宫门票","¥30","海淀区市一卡通","丰台区一卡通","130","13:00 前可预定今日票",1));
//        lists.add(new JQXQBean("【电子导游】北京市天坛门票","¥40","顺义区一卡通","大兴区一卡通","140","14:00 前可预定今日票",0));
//        lists.add(new JQXQBean("【电子导游】北京市颐和园门票","¥50","房山区一卡通","北京市一卡通","150","15:00 前可预定今日票",1));
//        lists.add(new JQXQBean("【电子导游】北京市圆明园门票","¥60","通州区一卡通","门头沟区一卡通","160","16:00 前可预定今日票",0));
//        mAdapter.setData(lists);
//        //初始化分隔线、添加分隔线
//        mDivider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        mDivider.setDrawable(getResources().getDrawable(R.drawable.jqxq_divider));
//        rcView.addItemDecoration(mDivider);
//        rcView.setAdapter(mAdapter);


//        mAdapterA = new JQXQAdapterA(this,lists,R.layout.item_layout_jxtj);
//        myGridView.setAdapter(mAdapter);
//        ivBan.requestFocus();
//        myGridView.setFocusable(false);
//
//
//        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            }
//        });
    }

    private void initViews() {
//        StatusBarUtil.setTranslucent(this);
        int index=R.drawable.jqxq_banner;
        Glide.with(this).load(index).into(ivBan);

        //加上横线
        eTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG );
        fTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG );
        gTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG );
        hTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG );
//        ImageUtils.decodeOptionsFromResource(CoreApp.getAppResources(),R.drawable.jdxq_banner);
//        ivBan.setImageResource(R.drawable.jdxq_banner);

        // set interpolators for both expanding and collapsing animations
//        expandableTextView.setInterpolator(new OvershootInterpolator());
//
//        // or set them separately
//        expandableTextView.setExpandInterpolator(new OvershootInterpolator());
//        expandableTextView.setCollapseInterpolator(new OvershootInterpolator());
//
//        // toggle the ExpandableTextView
//        textViewMSG.setOnClickListener(new View.OnClickListener()
//        {
//            @SuppressWarnings("ConstantConditions")
//            @Override
//            public void onClick(final View v)
//            {
//                if (expandableTextView.isExpanded())
//                {
//                    expandableTextView.collapse();
//                    textViewMSG.setText(R.string.expand);
//                }
//                else
//                {
//                    expandableTextView.expand();
//                    textViewMSG.setText(R.string.collapse);
//                }
//            }
//        });

    }

    private void initData() {
        MpgmBean data= (MpgmBean) getIntent().getSerializableExtra("data");
//        setToolBar(toolbar,"");
//        toolbar.setSubtitle(data.getPj());
//
        mArrLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d("STATE", state.name());
                if( state == State.EXPANDED ) {

                    //展开状态
                    mCoolToolbar.setTitle("");
//                    tagLL.setVisibility(View.VISIBLE);
//                    tv_name.setText(data.getName());
//                    tv_name.setVisibility(View.VISIBLE);
//                    mCoolToolbar.setTitle(data.getName());
                    coolTvTitle.setVisibility(View.VISIBLE);
                    toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(android.R.color.transparent));
                }else if(state == State.COLLAPSED){
                    //折叠状态
//                    mCoolToolbar.setTitle(data.getName());
//                    toolbar.setTitle(data.getName());
//                    tv_name.setVisibility(View.GONE);
//                    tv_name.setVisibility(View.GONE);
//                    mCoolToolbar.setExpandedTitleColor(getResources().getColor(R.color.color_343434));
                    coolTvTitle.setVisibility(View.GONE);
                    mCoolToolbar.setTitle(data.getName());
                    mCoolToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.color_343434));
                    toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(R.color.tabSelectedTextColor));

                }else {

                    //中间状态
                    toolbar.setBackgroundColor(CoreApp.getAppResources().getColor(android.R.color.transparent));
//                    mCoolToolbar.setTitle("");


                }
            }
        });
//        mCoolToolbar.setTitle(data.getName());
        coolTvTitle.setText(data.getName());
        tv_pf.setText(data.getPf());
        tv_Pj.setText(data.getPj());
        title.setText(data.getName()+"门票");
        tptv.setText("("+data.getZka()+")");
        yjtv.setText(data.getYj());
        yjtv.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        zjtv.setText(data.getZj());

//        tv_Zka.setText(data.getZka());
//        tv_Zkb.setText(data.getZkb());
//        tv_Zkc.setText(data.getZkc());




    }



    @Override
    public void onPause() {
        super.onPause();
//        banner.stopAutoPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public boolean isOpen() {
        return false;
    }
}
