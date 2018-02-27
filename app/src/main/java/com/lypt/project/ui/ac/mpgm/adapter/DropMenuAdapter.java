package com.lypt.project.ui.ac.mpgm.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.lypt.project.R;
import com.lypt.project.widget.drop.adapter.MenuAdapter;
import com.lypt.project.widget.drop.adapter.SimpleTextAdapter;
import com.lypt.project.widget.drop.entity.FilterUrl;
import com.lypt.project.widget.drop.interfaces.OnFilterDoneListener;
import com.lypt.project.widget.drop.interfaces.OnFilterItemClickListener;
import com.lypt.project.widget.drop.typeview.SingleGridView;
import com.lypt.project.widget.drop.typeview.SingleListView;
import com.lypt.project.widget.drop.util.UIUtil;
import com.lypt.project.widget.drop.view.FilterCheckedTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public class DropMenuAdapter implements MenuAdapter {

    private Context mContext;
    private String[] titles;
    private OnFilterDoneListener onFilterDoneListener;

    public DropMenuAdapter(Context context, String[] titles, OnFilterDoneListener onFilterDoneListener) {
        this.mContext = context;
        this.titles = titles;
        this.onFilterDoneListener = onFilterDoneListener;
    }



    @Override
    public int getMenuCount() {
        return titles.length;
    }

    @Override
    public String getMenuTitle(int position) {
        return titles[position];
    }

    @Override
    public int getBottomMargin(int position) {
        if (position==2)
        {
            return 0;
        }
        return UIUtil.dp(mContext, 140);
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {
        View view = parentContainer.getChildAt(position);
        switch (position) {
            case 0:
                view = createSingleListView();
                break;
            case 1:
                view = JingQuGridView();
                break;
            case 2:
                view = PingFenGridView();
                break;
            default:
        }

        return view;
    }
    private View JingQuGridView() {
        SingleListView<String> singleGridView = new SingleListView<String>(mContext)
                .adapter(new SimpleTextAdapter<String>(null, mContext) {
                    @Override
                    public String provideText(String s) {
                        return s;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
//                        checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
//                        checkedTextView.setGravity(Gravity.CENTER);
//                        checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item) {
                        FilterUrl.instance().singleGridPosition = item;

                        FilterUrl.instance().position = 1;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();

                    }
                });

        List<String> list = new ArrayList<>();
        list.add("5A景区");
        list.add("4A景区");
        list.add("3A景区");
        singleGridView.setList(list, -1);

        return singleGridView;
    }
    private void onFilterDone() {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(0, "", "");
        }
    }
    private View createSingleListView() {
        SingleListView<String> singleListView = new SingleListView<String>(mContext)
                .adapter(new SimpleTextAdapter<String>(null, mContext) {
                    @Override
                    public String provideText(String string) {
                        return string;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item) {
                        FilterUrl.instance().singleListPosition = item;

                        FilterUrl.instance().position = 0;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();
                    }
                });

        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        singleListView.setList(list, -1);


        return singleListView;
    }

    private View PingFenGridView() {
        SingleListView<String> singleGridView = new SingleListView<String>(mContext)
                .adapter(new SimpleTextAdapter<String>(null, mContext) {
                    @Override
                    public String provideText(String s) {
                        return s;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
//                        checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
//                        checkedTextView.setGravity(Gravity.CENTER);
//                        checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item) {
                        FilterUrl.instance().singleGridPosition = item;

                        FilterUrl.instance().position = 2;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();

                    }
                });

        List<String> list = new ArrayList<>();
        list.add("评分优先");
        list.add("人气优先");
        list.add("评论优先");
        list.add("价格高序");
        list.add("价格低序");
        singleGridView.setList(list, -1);

        return singleGridView;
    }
}
