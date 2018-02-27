package com.lypt.project.ui.ac.jqxq.adapter;

import android.content.Context;

import com.lypt.project.R;
import com.lypt.project.ui.ac.jqxq.model.JQXQBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 *
 * Created by Administrator on 2018/1/2.
 */

public class JQXQAdapter extends SuperAdapter<JQXQBean> {

    public JQXQAdapter(Context context, List<JQXQBean> datas, int layoutResId) {
        super(context, datas, layoutResId);
    }


    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, JQXQBean data) {
        holder.setText(R.id.thtj_title,data.getTitle());
        holder.setText(R.id.thtj_item_xj,data.getXj());
        holder.setText(R.id.thtj_item_btna,data.getBtna());
        holder.setText(R.id.thtj_item_btnb,data.getBtnb());
        holder.setText(R.id.thtj_item_yj,data.getYj());
        holder.setPaintFlag(R.id.thtj_item_yj);
        holder.setText(R.id.thtj_jt,data.getGptime());
        int state =data.getYdstate();
        switch (state){
            case 0:
                holder.setBackgroundColor(R.id.thtj_btn_yd,R.drawable.shape_btn_thtj_z);
                break;

            case 1:
                holder.setBackgroundColor(R.id.thtj_btn_yd,R.drawable.shape_btn_thtj_f);
                break;
            default:
        }
    }
}
