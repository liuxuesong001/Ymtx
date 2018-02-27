package com.lypt.project.ui.ac.mpgm;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.AppUtils;
import com.lypt.project.R;
import com.lypt.project.ui.ac.mpgm.adapter.DropMenuAdapter;
import com.lypt.project.widget.editview.SearchViewEditText;
import com.lypt.project.widget.drop.entity.FilterUrl;
import com.lypt.project.ui.ac.mpgm.adapter.MPGMAdapter;
import com.lypt.project.ui.ac.mpgm.model.MpgmBean;
import com.lypt.project.widget.drop.DropDownMenu;
import com.lypt.project.widget.drop.interfaces.OnFilterDoneListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * Created by Administrator on 2017/12/29.
 */

public class MPGMAvtivity extends CoreBaseActivity implements OnFilterDoneListener {
    //

    @BindView(R.id.toolbar_mpgm)
    Toolbar toolbar;
    //    @BindView(R.id.elViews)
//    ExpandableView mExpandableView;
    //    @BindView(R.id.coreReView)
//    CoreRecyclerView coreReView;
    @BindView(R.id.mFilterContentView)
    RecyclerView mRecyclerView;

    @BindView(R.id.home_back)
    ImageView back;


    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    private MPGMAdapter mpgmAdapter;

    private DividerItemDecoration mDivider;

    @BindView(R.id.ser)
    SearchViewEditText searchViewCum;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mpgm;
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
//        StatusBarUtil.setColor(this,getResources().getColor(R.color.tabSelectedTextColor));
//        setToolBar(toolbar,"");
        initFilterDropDownView();
        initAdapter();


//        searchViewCum = new SearchViewCum(MPGMAvtivity.this);
        searchViewCum.setMyHint("古水北镇");


    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "北京", "5A景区", "评分优先"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));

    }

    private void initAdapter() {
        mpgmAdapter = new MPGMAdapter(this,null,R.layout.item_mpgm_content);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        List<MpgmBean> lists=new ArrayList<>();
        lists.add(new MpgmBean(R.drawable.gsbz_mpgm_icon,"古水北镇","4.6分","2538条评价","150","持京津冀一卡通八折","","","120","距市区中心1.1km·古水北镇"));
        lists.add(new MpgmBean(R.drawable.gg_mpgm_icon,"故宫","4.8分","48270条评价","80","赠送景山公园门票","","","40","距距市区中心1.km·天安门"));
        lists.add(new MpgmBean(R.drawable.ymy_mpgm_icon,"圆明园","4.7分","8239条评价","10","赠送颐和园门票","全国一卡通9折","","5","距市区距离16.1km·中关村"));
        lists.add(new MpgmBean(R.drawable.bdlcc_mpgm_icon,"八达岭长城","4.6分","10297条评价","60","京津冀一卡通八折","全国一卡通9折","","35","距市区距离65.8km·延庆"));
        lists.add(new MpgmBean(R.drawable.yhy_mpgm_icon,"颐和园","4.7分","16410条评价","15","赠送圆明园门票","全国一卡通9折","","10","距市区距离30.2km·海淀"));
        mpgmAdapter.setData(lists);
        //初始化分隔线、添加分隔线
        mDivider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(getResources().getDrawable(R.drawable.jqxq_divider));
        mRecyclerView.addItemDecoration(mDivider);
        mRecyclerView.setAdapter(mpgmAdapter);




//        mpgmAdapter.setOnItemDataClickListener(new OnItemDataClickListener<MpgmBean>() {
//            @Override
//            public void onItemClick(View itemView, int viewType, int position, List<MpgmBean> data) {
//                Intent intent=new Intent(MPGMAvtivity.this,JQXQActivity.class);
//                intent.putExtra("data", data.get(position));
//                startActivity(intent);
//            }
//        });




    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 2) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FilterUrl.instance()
                .clear();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (AppUtils.isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    searchViewCum.isCursorVisible(false);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);

    }


}
