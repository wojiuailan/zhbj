package xin.shengnan.zhbj.pager;

import android.app.Activity;
import android.view.View;

import xin.shengnan.zhbj.R;

/**
 * Created by ${Li} on 2018/6/7.
 */

public class ViewPagerHome extends ViewPagerBase {
    public ViewPagerHome(Activity activity) {
        super(activity);
    }

    @Override
    View initView(Activity activity) {
        return View.inflate(activity, R.layout.view_pager_home, null);
    }
}
