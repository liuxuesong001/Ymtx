package com.lypt.project.ui.ac.tssp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.lypt.project.R;
import com.lypt.project.ui.ac.jqxq.JQXQActivity;
import com.lypt.project.ui.ac.mpgm.adapter.MPGMGridAdapter;
import com.lypt.project.ui.ac.mpgm.model.MpgmBean;
import com.lypt.project.ui.ac.tssp.model.TsspBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 *
 * Created by Administrator on 2018/1/2.
 */



public class TSSPAdapter extends SuperAdapter<TsspBean> {


    private Context context;

    public TSSPAdapter(Context context, List<TsspBean> list, int layoutResId) {
        super(context, list, layoutResId);
        this.context=context;
    }


    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, TsspBean data) {
        holder.setImageResource(R.id.mpgm_iv, data.getImg());
        holder.setText(R.id.mpgm_item_name, data.getName());
        holder.setText(R.id.mpgm_item_pj, data.getPf());
        holder.setText(R.id.mpgm_item_pjnum, data.getPj());
        holder.setText(R.id.mpgm_item_yj, data.getYj());
        //加上横线
        holder.setPaintFlag(R.id.mpgm_item_yj);
        holder.setText(R.id.mpgm_item_jl, data.getJl());
        holder.setText(R.id.mpgm_item_zj, data.getZj());

        holder.setOnClickListener(R.id.mpgm_btn_ckxq, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, JQXQActivity.class);
//                intent.putExtra("data", data);
//                context.startActivity(intent);
            }
        });

        holder.setText(R.id.mpgm_tv_zka, data.getZka());
        holder.setBackgroundResource(R.id.mpgm_tv_zka, R.drawable.shape_btn_zc_a);
        holder.setTextColor(R.id.mpgm_tv_zka, context.getResources().getColor(R.color.tabSelectedTextColor));
        if (!data.getZkb().equals("")) {
            holder.setText(R.id.mpgm_tv_zkb, data.getZkb());
            holder.setTextColor(R.id.mpgm_tv_zkb, context.getResources().getColor(R.color.color_f9651c));
            holder.setBackgroundResource(R.id.mpgm_tv_zkb, R.drawable.shape_btn_zc_b);
        }

        if (!data.getZkc().equals("")) {
            holder.setText(R.id.mpgm_tv_zkc, data.getZkc());
            holder.setTextColor(R.id.mpgm_tv_zkc, context.getResources().getColor(R.color.color_f9651c));
            holder.setBackgroundResource(R.id.mpgm_tv_zkc, R.drawable.shape_btn_zc_b);
        }

    }

}
