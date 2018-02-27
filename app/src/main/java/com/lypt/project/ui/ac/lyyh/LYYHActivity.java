package com.lypt.project.ui.ac.lyyh;

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
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.lypt.project.R;
import com.lypt.project.ui.ac.lyyh.adapter.LYYHAdapter;
import com.lypt.project.ui.ac.lyyh.model.LYYHBean;
import com.lypt.project.ui.ac.mpgm.adapter.DropMenuAdapter;
import com.lypt.project.widget.drop.DropDownMenu;
import com.lypt.project.widget.drop.entity.FilterUrl;
import com.lypt.project.widget.drop.interfaces.OnFilterDoneListener;
import com.lypt.project.widget.editview.SearchViewEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * Created by Administrator on 2017/12/29.
 */

public class LYYHActivity extends CoreBaseActivity implements OnFilterDoneListener {

    @BindView(R.id.toolbar_lyyh)
    Toolbar toolbar;
    @BindView(R.id.mFilterContentView)
    RecyclerView mRecyclerView;


    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    @BindView(R.id.editser)
    SearchViewEditText editSer;

    private LYYHAdapter lyyhAdapter;

    private DividerItemDecoration mDivider;

    @Override
    public int getLayoutId() {
        return R.layout.activity_lyyh;
    }

    @BindView(R.id.home_back)
    ImageView back;

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

        editSer.setMyHint("京津冀一卡通");

    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "北京", "5A景区", "评分优先"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));

    }

    private void initAdapter() {
        lyyhAdapter = new LYYHAdapter(this,null,R.layout.item_mpgm_content);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        List<LYYHBean> lists=new ArrayList<>();
        lists.add(new LYYHBean(R.drawable.lyyh_c,"京津冀旅游一卡通","4.6分","2538条评价","","官方授权","正品保证","","200","享京津冀158景区8折旅游优惠，部分景区免费游览"));
        lists.add(new LYYHBean(R.drawable.lyyh_b,"颐和园(赠送圆明园门票)","4.8分","48270条评价","","官方授权","正品保证","","20","门票类型:直连电子票"));
        lists.add(new LYYHBean(R.drawable.lyyh_a,"故宫(赠送珍宝馆门票)","4.7分","8239条评价","","人文建筑","正品保证","","40","门票类型:手工电子票"));
        lists.add(new LYYHBean(R.drawable.lyyh_tt,"人文建筑游览套票","4.8分","2538条评价","","人文建筑","正品保证","","180","天安门广场+故宫+天坛+八达岭长城"));
        lists.add(new LYYHBean(R.drawable.lyyh_nc,"鸟巢(赠送水立方门票)","4.8分","2538条评价","","官方授权","正品保证","","100","门票类型:手工电子票"));
        lyyhAdapter.setData(lists);
        //初始化分隔线、添加分隔线
        mDivider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(getResources().getDrawable(R.drawable.jqxq_divider));
        mRecyclerView.addItemDecoration(mDivider);
        mRecyclerView.setAdapter(lyyhAdapter);




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
                    editSer.isCursorVisible(false);
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
