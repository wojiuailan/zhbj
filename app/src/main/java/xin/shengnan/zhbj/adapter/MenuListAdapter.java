package xin.shengnan.zhbj.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.model.NewsCategories;

/**
 * Created by ${Li} on 2018/6/8.
 */

public class MenuListAdapter extends BaseAdapter {
    ArrayList<NewsCategories.MenuListItem> mData;
    private MainActivity mActivity;

    public MenuListAdapter(ArrayList<NewsCategories.MenuListItem> data, Activity activity) {
        mData = data;
        mActivity = (MainActivity) activity;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_list, null);
        TextView tv = v.findViewById(R.id.tv_menu_item);
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mActivity.setNewData(mData.get(position));
            }
        });
        tv.setText(mData.get(position).title);
        return v;
    }
}
