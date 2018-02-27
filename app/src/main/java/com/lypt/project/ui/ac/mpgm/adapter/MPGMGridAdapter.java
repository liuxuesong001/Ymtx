package com.lypt.project.ui.ac.mpgm.adapter;

import android.content.Context;

import com.lypt.project.R;
import com.lypt.project.ui.ac.mpgm.model.MpgmBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 *
 * Created by Administrator on 2018/1/2.
 */



public class MPGMGridAdapter extends SuperAdapter<MpgmBean> {


   private Context context;

    public MPGMGridAdapter(Context context, List<MpgmBean> list, int layoutResId) {
        super(context, list, layoutResId);
        this.context=context;
    }


    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MpgmBean data) {
//          if (data.getZk().equals("5A景区"))
//          {
//              holder.setText(R.id.mpgm_item_zktv,data.getZk());
//              holder.setBackgroundResource(R.id.mpgm_item_zktv,R.drawable.shape_btn_zc_a);
//          }else {
//              holder.setText(R.id.mpgm_item_zktv,data.getZk());
//              holder.setBackgroundResource(R.id.mpgm_item_zktv, R.drawable.shape_btn_zc_b);
//              holder.setTextColor(R.id.mpgm_item_zktv,context.getResources().getColor(R.color.color_f9651c));
//          }

    }
}
