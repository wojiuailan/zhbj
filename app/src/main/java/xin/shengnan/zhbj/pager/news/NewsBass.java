package xin.shengnan.zhbj.pager.news;

import android.app.Activity;
import android.view.View;

import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.model.NewsCategories;

/**
 * Created by ${Li} on 2018/6/9.
 */

public abstract class NewsBass {
    private View mRootView;
    private MainActivity mActivity;

    public NewsBass(Activity activity) {
        mRootView = initView();
        mActivity = (MainActivity) activity;
    }

    abstract View initView();
    public abstract void initData(NewsCategories.MenuListItem child);

    /**
     * 获取根视图
     * @return
     */
    public View getRootView() {
        return mRootView;
    }

    /**
     * 获取MainActivity
     * @return
     */
    public MainActivity getActivity() {
        return mActivity;
    }
}
