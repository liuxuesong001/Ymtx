package com.lypt.project.ui.fm.child.adapter;

import android.content.Context;

import com.lypt.project.R;
import com.lypt.project.ui.fm.child.model.HomeBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/1/5.
 */

public class HomeAdapter extends SuperAdapter<HomeBean> {

    public HomeAdapter(Context context, List<HomeBean> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, HomeBean item) {

        holder.setImageResource(R.id.item_con_iv,item.getImg());
        holder.setText(R.id.home_item_title,item.getName());
        holder.setText(R.id.home_item_content,item.getContent());
        holder.setText(R.id.item_item_xh,item.getXh());
        holder.setText(R.id.item_item_pl,item.getPf());
        holder.setText(R.id.home_item_yj,item.getYj());
        //加上横线
        holder.setPaintFlag(R.id.home_item_yj);
        holder.setText(R.id.home_item_zj,item.getZj());

    }
}
