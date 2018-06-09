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

    public void initData() {
        //设置按钮不可见
        setMenuInvisible();
        //设置标题
        setTitleText("首页");
    }

    @Override
    public View initView(Activity activity) {
        View v = View.inflate(activity, R.layout.view_pager_home, null);
        return v;
    }
}
