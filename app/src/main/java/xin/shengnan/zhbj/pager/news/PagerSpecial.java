package xin.shengnan.zhbj.pager.news;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.model.NewsCategories;

/**
 * Created by ${Li} on 2018/6/9.
 */

public class PagerSpecial extends NewsBass {
    public PagerSpecial(Activity activity) {
        super(activity);
    }

    @Override
    View initView() {
        View v = View.inflate(getActivity(), R.layout.pager_news, null);
        return v;
    }

    @Override
    public void initData(NewsCategories.MenuListItem item) {
    }
}
