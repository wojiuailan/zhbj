package xin.shengnan.zhbj.pager;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import xin.shengnan.zhbj.R;
import xin.shengnan.zhbj.activity.MainActivity;
import xin.shengnan.zhbj.model.NewsCategories;

/**
 * Created by ${Li} on 2018/6/7.
 */

public abstract class ViewPagerBase {
    private Activity mActivity;
    private View mRootView;


    private ImageButton mIBMenu;

    public ImageButton getIBMenu() {
        return mIBMenu;
    }

    private TextView mTVTitle;

    public ViewPagerBase(Activity activity) {
        mActivity = activity;

        mRootView = initView(mActivity);

        mTVTitle = mRootView.findViewById(R.id.tv_title);
        mIBMenu = mRootView.findViewById(R.id.ib_menu);
    }

    /**
     *
     * 让子类实现View
     *
     * @param activity
     * @return
     */
    public abstract View initView(Activity activity);
    public abstract void initData();

    /**
     * 获得View
     * @return
     */
    public View getRootView() {
        return mRootView;
    }

    /**
     * 设置ImageButton不可见
     */
    public void setMenuInvisible() {
        mIBMenu.setVisibility(View.GONE);


    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitleText(String title) {
        mTVTitle.setText(title);
    }

    /**
     * 获得MainActivity
     * @return
     */
    public MainActivity getActivity() {
        return (MainActivity) mActivity;
    }
}
