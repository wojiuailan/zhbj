package xin.shengnan.zhbj.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.adapter.MenuListAdapter;
import xin.shengnan.zhbj.model.NewsCategories;

/**
 * Created by ${Li} on 2018/6/6.
 */

public class FragmentMenu extends FragmentBase {

    private ListView mLVMenu;
    private ArrayList<NewsCategories.MenuListItem> mMenuListData;

    @Override
    protected void initData() {}

    @Override
    View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_menu, null);
        mLVMenu = v.findViewById(R.id.lv_menu);
        return v;
    }

    public void setMenuData(ArrayList<NewsCategories.MenuListItem> itemList) {
        mMenuListData = itemList;
        initMenuListData();
    }

    private void initMenuListData() {
        mLVMenu.setAdapter(new MenuListAdapter(mMenuListData, mActivity));
    }
}
