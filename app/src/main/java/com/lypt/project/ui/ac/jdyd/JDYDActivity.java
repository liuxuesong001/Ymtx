package com.lypt.project.ui.ac.jdyd;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.lypt.project.R;
import com.lypt.project.ui.ac.jdyd.adapter.JDYDAdapter;
import com.lypt.project.ui.ac.jdyd.model.JDYDBean;
import com.lypt.project.ui.ac.mpgm.adapter.DropMenuAdapter;
import com.lypt.project.widget.drop.DropDownMenu;
import com.lypt.project.widget.drop.entity.FilterUrl;
import com.lypt.project.widget.drop.interfaces.OnFilterDoneListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * Created by Administrator on 2017/12/29.
 */

public class JDYDActivity extends CoreBaseActivity implements OnFilterDoneListener {

    @BindView(R.id.toolbar_jdyd)
    Toolbar toolbar;
    @BindView(R.id.mFilterContentView)
    RecyclerView mRecyclerView;


    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    private JDYDAdapter jdydAdapter;

    private DividerItemDecoration mDivider;

    @Override
    public int getLayoutId() {
        return R.layout.activity_jdyd;
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

    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "全国", "5A景区", "评分优先"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));

    }

    private void initAdapter() {
        jdydAdapter = new JDYDAdapter(this,null,R.layout.item_mpgm_content);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        List<JDYDBean> lists=new ArrayList<>();
        lists.add(new JDYDBean(R.drawable.jdyd_a,"人民大会堂宾馆","4.6分","2538条评价","","亲子酒店","正品保证","","680","(人民大会堂南门对面),近天安门广场"));
        lists.add(new JDYDBean(R.drawable.jdyd_b,"北京丽景湾国际酒店","4.8分","48270条评价","","休闲度假","商务出行","","696","国贸地区燕莎,三里屯商业区"));
        lists.add(new JDYDBean(R.drawable.jdyd_c,"北京天坛和颐酒店","4.7分","8239条评价","","亲子酒店","商务出行","","436","北京东城区地铁14号线"));
        lists.add(new JDYDBean(R.drawable.jdyd_d,"北京励骏酒店","4.7分","8239条评价","","浪漫情侣","商务出行","购物便捷","1113","天安门、王府井地区西单、金融街地区"));
        lists.add(new JDYDBean(R.drawable.jdyd_e,"北京王府井希尔顿酒店","4.7分","8239条评价","","亲子酒店","休闲度假","购物便捷","1598","王府井地区西单、金融街地区"));
        jdydAdapter.setData(lists);
        //初始化分隔线、添加分隔线
        mDivider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(getResources().getDrawable(R.drawable.jqxq_divider));
        mRecyclerView.addItemDecoration(mDivider);
        mRecyclerView.setAdapter(jdydAdapter);




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
}
