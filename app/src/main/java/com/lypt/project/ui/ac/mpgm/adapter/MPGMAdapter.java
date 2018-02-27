package com.lypt.project.ui.ac.mpgm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.lypt.project.R;
import com.lypt.project.ui.ac.jqxq.JQXQActivity;
import com.lypt.project.ui.ac.mpgm.model.MpgmBean;
import com.tencent.bugly.crashreport.CrashReport;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 *
 * Created by Administrator on 2018/1/2.
 */

//public class JDYDAdapter extends CommonBaseAdapter<MpgmBean> {
//
//    public JDYDAdapter(Context context, List<MpgmBean> datas, boolean isOpenLoadMore) {
//        super(context, datas, isOpenLoadMore);
//    }
//
//    @Override
//    protected void convert(ViewHolder holder, MpgmBean data) {
//        holder.setText(R.id.mpgm_item_name,data.getName());
//        holder.setText(R.id.mpgm_item_pj,data.getPj());
//        holder.setText(R.id.mpgm_item_btna,data.getZka());
//        holder.setText(R.id.mpgm_item_btnb,data.getZkb());
//        holder.setText(R.id.mpgm_item_yj,data.getYj());
//        //加上横线
//        holder.setPaintFlag(R.id.mpgm_item_yj);
//        holder.setText(R.id.mpgm_item_jl,data.getJl());
//        holder.setText(R.id.mpgm_item_zj,data.getZj());
//
//    }
//
//    @Override
//    protected int getItemLayoutId() {
//        return R.layout.item_mpgm_content;
//    }
//}

public class MPGMAdapter extends SuperAdapter<MpgmBean> {



    private Context context;

    private MPGMGridAdapter mpgmGridAdapter;


    private  int MAX = 18;

    public MPGMAdapter(Context context, List<MpgmBean> list, int layoutResId) {
        super(context, list, layoutResId);
        this.context=context;
    }


    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MpgmBean data) {
        holder.setImageResource(R.id.mpgm_iv,data.getImg());
        holder.setText(R.id.mpgm_item_name,data.getName());
        holder.setText(R.id.mpgm_item_pj,data.getPf());
        holder.setText(R.id.mpgm_item_pjnum,data.getPj());
//        holder.setText(R.id.mpgm_item_btna,data.getZka());
//        holder.setText(R.id.mpgm_item_btnb,data.getZkb());
        holder.setText(R.id.mpgm_item_yj,data.getYj());
        //加上横线
        holder.setPaintFlag(R.id.mpgm_item_yj);
        holder.setText(R.id.mpgm_item_jl,data.getJl());
        holder.setText(R.id.mpgm_item_zj,data.getZj());

        holder.setOnClickListener(R.id.mpgm_btn_ckxq, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutPosition==0)
                {
                    Intent intent=new Intent(context,JQXQActivity.class);
                    intent.putExtra("data", data);
                    context.startActivity(intent);
                }

//                CrashReport.testJavaCrash();
            }
        });

        holder.setText(R.id.mpgm_tv_zka,data.getZka());
        holder.setBackgroundResource(R.id.mpgm_tv_zka,R.drawable.shape_btn_zc_b);
        holder.setTextColor(R.id.mpgm_tv_zka,context.getResources().getColor(R.color.color_f9651c));
        if (!data.getZkb().equals(""))
        {
            holder.setText(R.id.mpgm_tv_zkb,data.getZkb());
            holder.setTextColor(R.id.mpgm_tv_zkb,context.getResources().getColor(R.color.color_bd72f2));
            holder.setBackgroundResource(R.id.mpgm_tv_zkb,R.drawable.shape_btn_zc_c);
        }

        if (!data.getZkc().equals(""))
        {
            holder.setText(R.id.mpgm_tv_zkc,data.getZkc());
            holder.setTextColor(R.id.mpgm_tv_zkc,context.getResources().getColor(R.color.color_bd72f2));
            holder.setBackgroundResource(R.id.mpgm_tv_zkc,R.drawable.shape_btn_zc_c);
        }


//        mpgmGridAdapter = new MPGMGridAdapter(context,null,R.layout.item_mpgm_zk);
//        mpgmGridAdapter.setData(getData());
//        holder.setAdapter(R.id.mpgm_gtidview_zk, (Adapter) mpgmGridAdapter);

//        RecyclerView recyclerView=holder.getView(R.id.mpgm_gtidview_zk);
//        if (recyclerView!=null)
//        {
//            GridLayoutManager layoutManager =new GridLayoutManager(context,3);
//            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                @Override
//                public int getSpanSize(int position) {
//                    return setSpanSize(position,getData());
//                }
//            });
//            recyclerView.setLayoutManager(layoutManager);
//            recyclerView.addItemDecoration(new GridSpacingItemDecoration(3,10,false));
//            recyclerView.addItemDecoration(new SpacesItemDecoration(10));
//            recyclerView.setAdapter(mpgmGridAdapter);
//        }

    }

//    private int setSpanSize(int position, List<MpgmBean> data) {
//        int count;
//        if (data.get(position).getZk().length() > MAX) {
//            count = 3;
//        } else {
//            count = 1;
//        }
//
//        return count;
//    }


}
