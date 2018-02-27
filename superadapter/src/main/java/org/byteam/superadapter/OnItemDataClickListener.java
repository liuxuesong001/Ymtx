package org.byteam.superadapter;

import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface OnItemDataClickListener<T> {

    void onItemClick(View itemView, int viewType, int position,List<T> data);
}
