package xin.shengnan.zhbj.pager.news;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.model.NewsCategories;

/**
 * Created by ${Li} on 2018/6/9.
 */

public class PagerNews extends NewsBass {
    public PagerNews(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        return View.inflate(getActivity(), R.layout.pager_news, null);
    }

    @Override
    public void initData(NewsCategories.MenuListItem item) {

    }
}
