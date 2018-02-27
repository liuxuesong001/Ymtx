package com.lypt.project.ui.ac.tssp;

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
import com.lypt.project.ui.ac.tssp.adapter.DropMenuAdapter;
import com.lypt.project.ui.ac.tssp.adapter.TSSPAdapter;
import com.lypt.project.ui.ac.tssp.model.TsspBean;
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

public class TSSPActivity extends CoreBaseActivity implements OnFilterDoneListener {

    @BindView(R.id.toolbar_tssp)
    Toolbar toolbar;
    @BindView(R.id.mFilterContentView)
    RecyclerView mRecyclerView;


    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    @BindView(R.id.home_back)
    ImageView back;

    @BindView(R.id.editser)
    SearchViewEditText editSer;
    private TSSPAdapter tsspAdapter;

    private DividerItemDecoration mDivider;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tssp;
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

        editSer.setMyHint("手工剪纸");

    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "故宫", "5A景区", "评分优先"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));

    }

    private void initAdapter() {
        tsspAdapter = new TSSPAdapter(this,null,R.layout.item_mpgm_content);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        List<TsspBean> lists=new ArrayList<>();
        lists.add(new TsspBean(R.drawable.tssp_a,"故宫文创皇帝语录奏折笔记本","4.8分","2538条评价","10","纪念品","","","9.9","复古记事本子博物院创意纪念品礼品"));
        lists.add(new TsspBean(R.drawable.tssp_b,"北京故宫邮票册","4.9分","3618条评价","96","邮票册","","","58","中国风特色商务小礼品"));
        lists.add(new TsspBean(R.drawable.tssp_c,"剪纸书签礼物","4.8分","2531条评价","298","手工剪纸","传统工艺","","149","中英文剪纸书签礼物"));
        lists.add(new TsspBean(R.drawable.tssp_d,"银镀金耳坠","4.5分","2239条评价","180","传统花丝工艺","","","114" ,"祥云如意 花丝耳饰"));
        lists.add(new TsspBean(R.drawable.tssp_e,"香插烛台","4.6分","6538条评价","200","激光雕刻","","","150","信仰装饰"));
        tsspAdapter.setData(lists);
        //初始化分隔线、添加分隔线
        mDivider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(getResources().getDrawable(R.drawable.jqxq_divider));
        mRecyclerView.addItemDecoration(mDivider);
        mRecyclerView.setAdapter(tsspAdapter);




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
