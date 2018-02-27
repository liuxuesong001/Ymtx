package com.lypt.project.ui.ac.jqxq.adapter;

import android.content.Context;

import com.lypt.project.R;
import com.lypt.project.ui.ac.jqxq.model.JQXQBean;
import com.lypt.project.ui.ac.mpgm.model.MpgmBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 *
 * Created by Administrator on 2018/1/2.
 */

public class JQXQAdapterA extends SuperAdapter<MpgmBean> {

    public JQXQAdapterA(Context context, List<MpgmBean> datas, int layoutResId) {
        super(context, datas, layoutResId);
    }


    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, MpgmBean data) {





    }
}
